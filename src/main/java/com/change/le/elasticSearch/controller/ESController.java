package com.change.le.elasticSearch.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Controller
public class ESController {

    @Autowired
    private TransportClient client;

    private static Logger log = LoggerFactory.getLogger(ESController.class);



    @PutMapping("/put/book/novel")
    @ResponseBody
    public ResponseEntity put(@RequestParam(name = "title")String title,
                              @RequestParam(name = "author")String author,
                              @RequestParam(name = "word_count") int worldCount,
                              @RequestParam(name = "publish_date")
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date publishDate){
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title",title)
                    .field("author",author)
                    .field("word_count",worldCount)
                    .field("publish_date",publishDate.getTime())
                    .endObject();

            System.out.println("zhangsan....................");

            IndexResponse result =  this.client.prepareIndex("book","novel")
                    .setSource(content)
                    .get();

            return new ResponseEntity(result.getId(), HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/get/book/novel")
    @ResponseBody
    public ResponseEntity get(@RequestParam(name = "id",defaultValue = "")String id){
        System.out.println("dddddddddddddddddddddd");
        GetResponse result = this.client.prepareGet("book", "novel", id).get();
        if(!result.isExists()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 根据id更新指定的数据，level可以改变
     * @param id
     * @param level
     * @return
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @PostMapping("/updateByLevel")
    @ResponseBody
    public ResponseEntity update(@RequestParam(name="id")String id, @RequestParam(name = "level")String level) throws IOException, ExecutionException, InterruptedException {

        UpdateRequest request = new UpdateRequest();
        //event-fw-2019.09.16/security_scan/12
        request.index("event-fw-2019.09.16")
                .type("security_scan")
                .id(id)
                .doc(
                  XContentFactory.jsonBuilder()
                  .startObject()
                  .field("level",level)
                  .endObject()
                );
        UpdateResponse updateResponse = this.client.update(request).get();
        System.out.println(updateResponse.status());
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 自动更新
     * @return
     * @throws IOException
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @PostMapping("/updateAuto")
    @ResponseBody
    public ResponseEntity updateAuto() throws IOException, ExecutionException, InterruptedException {


        UpdateRequest request = new UpdateRequest();


        for (int i = 1; i <20 ; i++) {
            String level = "";
            if(i%7==0){
                 level = "0";
            }else if(i%7==1){
                 level = "1";
            }else if(i%7==2){
                 level = "2";
            }else if(i%7==3){
                 level = "3";
            }else if(i%7==4){
                 level = "4";
            }else if(i%7==5){
                 level = "5";
            }else if(i%7==6){
                 level = "6";
            }else{
                 level  = "7";
            }

            String id = i+"";


            request.index("event-fw-2019.09.16")
                    .type("security_abnormal_pkt")
                    .id(id)
                    .doc(
                            XContentFactory.jsonBuilder()
                                    .startObject()
                                    .field("level",level)
                                    .endObject()
                    );
            UpdateResponse updateResponse = this.client.update(request).get();
            System.out.println(updateResponse.status());

        }

        //event-fw-2019.09.16/security_scan/12
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 批量更新
     */
    @PostMapping("/updateByQuery")
    @ResponseBody
    public ResponseEntity updateByQuery(@RequestParam(name = "index")String index, @RequestParam(name = "level")String level){

        UpdateByQueryRequestBuilder builder = UpdateByQueryAction.INSTANCE.newRequestBuilder(this.client);

//        builder.source(index).
//                filter(QueryBuilders.termQuery("field",412)).//查询要修改的结果集
//                script(new Script("ctx._source['field']='"+level+"';ctx._source['field']='"+level+"'"));//修改操作

        Map<String,Object> params = new HashMap<>();
        params.put("level",0);
        ScriptType type = ScriptType.INLINE;
        String lang = "painless";
        String code = "ctx._source.level=params.level";

        Script script = new Script(type,lang,code,params);

        BulkByScrollResponse response = builder.
                source(index).
                script(script).
                filter(QueryBuilders.termQuery("age", level)).
                abortOnVersionConflict(false).get();

        System.out.println(response.getUpdated());
        //log.info(response.getUpdated());
//        //相应结果集
//        BulkByScrollResponse response = builder.get();
//        System.out.println(response.getUpdated());

        return new ResponseEntity(HttpStatus.OK);
    }


}
