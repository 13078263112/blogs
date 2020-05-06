package com.ywc.blogs.controller;

import com.ywc.blogs.entity.Admin;
import com.ywc.blogs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**用户控制器
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/16 16:30
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    //查询前六条原创的文章标题
    @PostMapping("/adminLogin")
    public Map<String,Object> queryAdminByNameAndpassword(@RequestBody Admin admin, HttpServletResponse response){
        Admin admin1 = adminService.queryAdminByNameAndpassword(admin);
        Map<String,Object> map=new HashMap<String,Object>();

        if (admin1==null){
            map.put("result ","200");
            map.put("msg","查询失败");
            map.put("list","账户或密码错误或被禁用");
        }else {
            map.put("result ","200");
            map.put("msg","查询成功");
            Cookie cookie=new Cookie("adminName",admin1.getAdminName());
            Cookie cookie1=new Cookie("adminId",admin1.getAdminId().toString());
            cookie.setMaxAge(24*60*60);
            cookie.setPath("/");
            cookie1.setMaxAge(24*60*60);
            cookie1.setPath("/");
            response.addCookie(cookie);
            response.addCookie(cookie1);
        }
        return map ;
    }
    //查询管理个数
    @GetMapping("/adminNum")
    public Map<String,Object> queryAdminByMun(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",adminService.queryAdminByNum());
        return map ;
    }
    //修改密码
    @PostMapping("/updateAdminPassword")
    public Map<String,Object> updateAdminByIdAndpassword( Admin admin, @RequestBody Map<String,Object> maps){
        Map<String,Object> map=new HashMap<String,Object>();
        admin.setAdminName((String) maps.get("adminName"));
        admin.setPassword((String) maps.get("password"));
        Admin admin1 = adminService.queryAdminByNameAndpassword(admin);
        if(admin1!=null){
            admin1.setPassword((String) maps.get("newpassword"));
            adminService.updateAdminByIdAndpassword(admin1);
            map.put("result ","200");
            map.put("msg","修改成功");
        }else{
            map.put("result ","200");
            map.put("msg","修改失败");
        }
        return map ;
    }
    //分页查询文章类型
    @GetMapping("/qeuryadminAllPaging")
    public Map<String,Object> queryAdminPaging(Integer pageNo,Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",adminService.queryAdminPaging(pageNo,pageSize));
        return map ;
    }
    //修改用户状态
    @GetMapping("/updateAdminStatus")
    public Map<String,Object> updateArticleByIsrecommend(Admin admin,Integer adminId,Integer adminStatus) {
        admin.setAdminId(adminId);
        admin.setAdminStatus(adminStatus);
        int i = adminService.updateAdminByIdAndAdminStatus(admin);
        Map<String,Object> map=new HashMap<String,Object>();
        if (i==0){
            map.put("result ","200");
            map.put("msg","恢复失败");
        }else{
            map.put("result ","200");
            map.put("msg","恢复成功");
        }
        return map ;
    }
    //批量修改用户状态
    @PostMapping("/updateBatchIsdelete")
    public Map<String,Object> updateArticleByBatchIsrecommend(Admin admin,Integer adminStatus,@RequestBody List<Integer> adminId) {

        int i=0;
        for (Integer integer : adminId) {
            admin.setAdminId(integer);
            admin.setAdminStatus(adminStatus);
            i += adminService.updateAdminByIdAndAdminStatus(admin);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        if (i!=adminId.size()){
            map.put("result ","200");
            map.put("msg","修改失败");
        }else{
            map.put("result ","200");
            map.put("msg","修改成功");
        }
        return map ;
    }
    //用户退出
    @PostMapping("/adminDecorporation")
    public Map<String,Object> adminDecorporation(HttpServletResponse response) {
        Cookie cookie=new Cookie("adminName","");
        cookie.setPath("/");
        response.addCookie(cookie);
        Map<String,Object> map=new HashMap<String,Object>();
            map.put("result ","200");
            map.put("msg","退出成功");
        return map ;
    }
}
