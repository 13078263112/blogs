package com.ywc.blogs.mapper;

import com.ywc.blogs.vo.CommentAuditVo;
import com.ywc.blogs.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**评论dao层
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 23:55
 */
@Repository
@Mapper
public interface CommentMapper {
    //查询所有评论数量
    int queryCommentAllNum();
    //后台分页查询
    List<CommentVo> queryCommentAllPaging(Integer pageNo, Integer pageSize);
    //根据评论ID来删除评论
    int deleteCommentBycommentId(Integer commentId);
    //根据文章ID来删除评论
    int deleteCommentByarticleId(Integer articleId);
    //把审核的转为通过的
    int insertComment(CommentAuditVo commentAuditVo);
    //前台根据文章Id来查询评论
    List<Map<String,String>> queryCommentByArticleId(Integer articleId);
}
