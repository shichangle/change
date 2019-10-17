package com.change.le.downloadFiles.service;


import com.change.le.downloadFiles.domain.Book;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class DownloadService {
    public File downloadFile() {


        //获取数据，可以读出来，可以查出来
        //1,从本地读文件


        //2,读取数据写进文件
        //查数据库数据
        List<Book> bookList = new ArrayList<>();



        //把数据写进excel文档或者直接写出数据两种情况
        //1,把读到的文件直接写出去


        //2,写进excel，其实也是一个文件，然后写出去
        String fileName = "张三的歌";
        String sheetName = "第一首";

        OutputStream os = null;
        File file = null;

        try {
            //填充数据
            HSSFWorkbook hssfWorkbook = getExcelContent(sheetName,bookList);

            file = new File(UUID.randomUUID().toString());
            os = new FileOutputStream(file);
            hssfWorkbook.write(os);
            os.flush();


            //这两个路径还有些问题
            File result = new File(fileName+".xls");//路径+文件名.后缀

            if(result.exists()){
                result.delete();
                result = new File(fileName+".xls");//路径+文件名.后缀
            }
            FileUtils.copyFile(file,result);//对文件的复制
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return new File(fileName);
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private HSSFWorkbook getExcelContent(String sheetName, List<Book> bookList) {
        //获取列标题  可以直接从数据中获取
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = null;

        if(sheet==null || "".equals(sheet)){
            sheet=hssfWorkbook.createSheet();
        }else{
            sheet = hssfWorkbook.createSheet(sheetName);
        }
        sheet.setDefaultColumnWidth(15);

        //在索引为0的位置创建第一行
        HSSFRow rowHead = sheet.createRow((short)0);

        //创建单元格头部标题
        int k = 0;
//        List<HashMap<String,String>> columns = logStructure.getColumns();
//        for (HashMap<String,String> column : columns) {
//            HSSFCell cell = rowHead.createCell(k++);//索引为i位置创建单元格
//            cell.setCellType(HSSFCell.CELL_TYPE_STRING);//定义单元格类型为字符串
//            cell.setCellValue(column.get("title"));//填充值
//        }




        //填充行数据
        int cellCount = 1;
        bookList.removeAll(Collections.singleton(null));

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            HSSFRow row = sheet.createRow(cellCount++);

            //填充列数据
            int cellNumber = 0;

            HSSFCell cell = row.createCell(cellNumber++);
          //  cell.setCellType(HSSFCell.CEll_Type_String);//为啥没有 ？？？
            cell.setCellValue(book.getName());

            HSSFCell cell2 = row.createCell(cellNumber++);
            //cell.setCellType(HSSFCell.CEll_Type_String);
            cell.setCellValue(book.getAuthor());

            HSSFCell cell3 = row.createCell(cellNumber++);
           // cell.setCellType(HSSFCell.CEll_Type_String);
            cell.setCellValue(book.getDate());
        }



        return hssfWorkbook;
    }
}
