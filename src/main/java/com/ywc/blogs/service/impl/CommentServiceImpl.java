package com.ywc.blogs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.mapper.CommentMapper;
import com.ywc.blogs.service.CommentService;
import com.ywc.blogs.vo.CommentAuditVo;
import com.ywc.blogs.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**评论业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 23:58
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int queryCommentAllNum() {
        return commentMapper.queryCommentAllNum();
    }

    @Override
    public PageInfo<CommentVo> queryCommentAllPaging(Integer pageNo, Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<CommentVo> commentVos = commentMapper.queryCommentAllPaging(pageNo, pageSize);
        PageInfo<CommentVo> pageInfo=new PageInfo<CommentVo>(commentVos);
        return pageInfo;
    }

    @Override
    public int deleteCommentBycommentId(Integer commentId) {
        return commentMapper.deleteCommentBycommentId(commentId);
    }

    @Override
    public int deleteCommentByarticleId(Integer articleId) {
        return commentMapper.deleteCommentByarticleId(articleId);
    }

    @Override
    public int insertComment(CommentAuditVo commentAuditVo) {
        return commentMapper.insertComment(commentAuditVo);
    }

    @Override
    public List<Map<String, String>> queryCommentByArticleId(Integer articleId) {
        return commentMapper.queryCommentByArticleId(articleId);
    }
}
