package com.ywc.blogs.controller;



import com.ywc.blogs.utility.ImgResult;
import com.ywc.blogs.utility.VerifyCodeUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

import java.util.*;



/**
 * @author 嘟嘟~~
 * @date 2019/12/30 10:36
 */
@RestController
@RequestMapping("/img")
public class ImgController {

    //获取验证码Img
    @GetMapping("/getYzm")
    public Map<String, Object> getYZM(HttpServletRequest request, HttpServletResponse response) {

        ImgResult rs = null;
        try {
            rs = VerifyCodeUtils.VerifyCode(100, 40, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("yzm", rs.getCode());
        //解决跨域问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result ", "200");
        map.put("msg", "查询成功");
        map.put("list", rs.getImg());
        return map;
    }
    //验证验证码的正确
    @GetMapping("/verifyyzm")
    public Map<String, Object> verifyYZM(HttpServletRequest request, String yzm) {

        String yzm1 = (String) request.getSession().getAttribute("yzm");
        Map<String, Object> map = new HashMap<String, Object>();
        if (yzm1.equalsIgnoreCase(yzm)) {
            map.put("result ", "200");
            map.put("msg", "验证正确");
            request.getSession().removeAttribute("yzm");
        } else {
            map.put("result ", "200");
            map.put("msg", "错误");
        }
        return map;
    }
    //上传图片
    @PostMapping ("/upload")
    public Map<String, Object> uploading(HttpServletRequest request,@Param("imgFile")MultipartFile imgFile) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        //创建输入流
        InputStream inputStream=imgFile.getInputStream();
        //生成输出地址URL
        long time = System.currentTimeMillis();
        //"E:\\ideaproject\\blogs_puls\\src\\main\\webapp\\static\\imgs\\"+time+".jpg"
        String outputPath="D:\\blogs_puls\\src\\main\\webapp\\static\\imgs\\"+time+".jpg";
        System.out.println(outputPath);
        //创建输出流
        OutputStream outputStream=new FileOutputStream(outputPath);
        //设置缓冲区
        byte[] buffer=new byte[1024];

        //输入流读入缓冲区，输出流从缓冲区写出
        while((inputStream.read(buffer))>0)
        {
            System.out.println(buffer);
            outputStream.write(buffer);
        }
        outputStream.close();
        inputStream.close();
        //返回原图上传后的相对地址
            map.put("error", 0);
            map.put("url","../static/imgs/"+time+".jpg");
        return map;
    }
}
