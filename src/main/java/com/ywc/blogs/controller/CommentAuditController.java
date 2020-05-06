package com.ywc.blogs.controller;

import com.ywc.blogs.service.CommentAuditService;
import com.ywc.blogs.service.CommentService;
import com.ywc.blogs.vo.CommentAuditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**评论待审核控制器
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/22 5:08
 */
@RestController
@RequestMapping("/commentAudit")
public class CommentAuditController {
    @Autowired
    private CommentAuditService commentAuditService;
    @Autowired
    private CommentService commentService;
    //分页查询待审核评论数据
    @GetMapping("/qeuryCommentAuditPaging")
    public Map<String,Object> queryCommentAuditPaging(Integer pageNo, Integer pageSize){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",commentAuditService.queryCommentAuditPaging(pageNo,pageSize));
        return map ;
    }
    //根据待评论Id同意通过
    @PostMapping("/consentCommentAuditId")
    public Map<String,Object> consentCommentAuditBycommentauditId(@RequestBody List<Integer> atypeId){
        for (Integer integer : atypeId) {
            commentService.insertComment( commentAuditService.qeuryCommentAuditBycommentauditId(integer));
            commentAuditService.deleteCommentAuditBycommentauditId(integer);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","同意成功");
        return map ;
    }
    //根据待评论Id删除评论
    @PostMapping("/deleteCommentAuditId")
    public Map<String,Object> deleteCommentAuditBycommentauditId(@RequestBody List<Integer> atypeId){
        for (Integer integer : atypeId) {
            commentAuditService.deleteCommentAuditBycommentauditId(integer);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","删除成功");
        return map ;
    }
    //根据待评论Id删除评论
    @PostMapping("/insertCommentAudit")
    public Map<String,Object> insertCommentAudit(CommentAuditVo commentAuditVo, @RequestBody Map<String,Object> maps) throws Exception {
        commentAuditVo.setArticleId(Integer.valueOf((String) maps.get("articleId")));
        commentAuditVo.setCommentauditConten((String) maps.get("commentauditConten"));
        commentAuditService.insertCommentAudit(commentAuditVo);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","评论成功");
        return map ;
    }
}
