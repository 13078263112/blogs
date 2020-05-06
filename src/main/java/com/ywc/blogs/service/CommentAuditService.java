package com.ywc.blogs.service;

import com.github.pagehelper.PageInfo;
import com.ywc.blogs.vo.CommentAuditVo;

import java.util.List;

/**评论待审核业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/22 5:03
 */
public interface CommentAuditService {
    //分页查询待审核评论数据
    PageInfo<CommentAuditVo> queryCommentAuditPaging(Integer pageNo, Integer pageSize);
    //根据Id查询待审核评论数据
    CommentAuditVo qeuryCommentAuditBycommentauditId(Integer commentauditId);
    //根据Id删除待审核评论数据
    int deleteCommentAuditBycommentauditId(Integer commentauditId);
    //前台添加待审核数据
    int insertCommentAudit(CommentAuditVo commentAuditVo) throws Exception;
}
