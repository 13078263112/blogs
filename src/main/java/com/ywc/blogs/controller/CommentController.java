package com.ywc.blogs.controller;

import com.ywc.blogs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**评论控制器
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 23:59
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    //查询所有评论数量
    @GetMapping("/commentnum")
    public Map<String,Object> queryCommentAllNum(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",commentService.queryCommentAllNum());
        return map ;
    }
    //分页查询评论数据
    @GetMapping("/qeuryCommentPaging")
    public Map<String,Object> queryCommentAllPaging(Integer pageNo,Integer pageSize){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",commentService.queryCommentAllPaging(pageNo,pageSize));
        return map ;
    }
    //根据评论Id来删除评论
    @PostMapping("/deleteCommentId")
    public Map<String,Object> deleteCommentBycommentId(@RequestBody List<Integer> atypeId){
        for (Integer integer : atypeId) {
            commentService.deleteCommentBycommentId(integer);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","删除成功");
        return map ;
    }
    //分页查询评论数据
    @GetMapping("/qeuryCommentByArticleId")
    public Map<String,Object> queryCommentByArticleId(Integer articleId){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",commentService.queryCommentByArticleId(articleId));
        return map ;
    }
}
