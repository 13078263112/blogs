package com.ywc.blogs.controller;

import com.ywc.blogs.utility.DownloadFileUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author 嘟嘟~~
 * @date 2019/12/30 20:27
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 文件下载
     */
    @GetMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,String pathname) {
        //"E:\\ideaproject\\blogs_puls\\src\\main\\webapp\\File\\"+pathname
        File file = new File("D:\\blogs_puls\\src\\main\\webapp\\File\\"+pathname);
        DownloadFileUtil.downloadFile(pathname,file,response,request);
    }

}
