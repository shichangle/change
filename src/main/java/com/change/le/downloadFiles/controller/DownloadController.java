package com.change.le.downloadFiles.controller;


import com.change.le.downloadFiles.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * 文件的下载
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

    @Autowired
    private DownloadService downloadService;


    @RequestMapping("/file")
    public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response){

        File file = downloadService.downloadFile();
        System.out.println(file);
    }
}
