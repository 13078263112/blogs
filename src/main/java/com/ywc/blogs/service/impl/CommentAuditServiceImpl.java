package com.ywc.blogs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.mapper.CommentAuditMapper;
import com.ywc.blogs.service.CommentAuditService;
import com.ywc.blogs.vo.CommentAuditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**评论待审核业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/22 5:04
 */
@Service
public class CommentAuditServiceImpl implements CommentAuditService {
    @Autowired
    private CommentAuditMapper commentAuditMapper;
    @Override
    public PageInfo<CommentAuditVo> queryCommentAuditPaging(Integer pageNo, Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<CommentAuditVo> commentAuditVos = commentAuditMapper.queryCommentAuditPaging();
        PageInfo<CommentAuditVo> pageInfo=new PageInfo<CommentAuditVo>(commentAuditVos);
        return pageInfo;
    }

    @Override
    public CommentAuditVo qeuryCommentAuditBycommentauditId(Integer commentauditId) {
        return commentAuditMapper.qeuryCommentAuditBycommentauditId(commentauditId);
    }

    @Override
    public int deleteCommentAuditBycommentauditId(Integer commentauditId) {
        return commentAuditMapper.deleteCommentAuditBycommentauditId(commentauditId);
    }

    @Override
    public int insertCommentAudit(CommentAuditVo commentAuditVo) throws Exception {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       commentAuditVo.setCommentauditCreateTime(dateformat.parse(dateformat.format(new Date())));
        return commentAuditMapper.insertCommentAudit(commentAuditVo);
    }
}
