package com.ywc.blogs.mapper;

import com.ywc.blogs.vo.CommentAuditVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**评论待审核dao层
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/22 4:56
 */
@Repository
@Mapper
public interface CommentAuditMapper {
    //分页查询待审核评论数据
    List<CommentAuditVo> queryCommentAuditPaging();
    //根据Id查询待审核评论数据
    CommentAuditVo qeuryCommentAuditBycommentauditId(Integer commentauditId);
    //根据Id删除待审核评论数据
    int deleteCommentAuditBycommentauditId(Integer commentauditId);
    //前台添加待审核数据
    int insertCommentAudit(CommentAuditVo commentAuditVo);
}
