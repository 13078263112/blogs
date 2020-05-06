package com.ywc.blogs.service;

import com.github.pagehelper.PageInfo;
import com.ywc.blogs.vo.CommentAuditVo;
import com.ywc.blogs.vo.CommentVo;

import java.util.List;
import java.util.Map;

/**评论业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 23:57
 */
public interface CommentService {
    //查询所有评论数量
    int queryCommentAllNum();
    //分页查询
    PageInfo<CommentVo> queryCommentAllPaging(Integer pageNo, Integer pageSize);
    //根据评论ID来删除评论
    int deleteCommentBycommentId(Integer commentId);
    //根据文章ID来删除评论
    int deleteCommentByarticleId(Integer articleId);
    //把审核的转为通过的
    int insertComment(CommentAuditVo commentAuditVo);
    //前台根据文章Id来查询评论
    List<Map<String,String>> queryCommentByArticleId(Integer articleId);
}
