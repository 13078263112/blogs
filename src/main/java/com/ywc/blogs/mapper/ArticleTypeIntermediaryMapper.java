package com.ywc.blogs.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**文章类型对应表dao层
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 22:54
 */
@Repository
@Mapper
public interface ArticleTypeIntermediaryMapper {
    int insertArticleTypeIntermediary(@Param("articleId") Integer articleId,@Param("articleTypeId") Integer articleTypeId);

    int deleteArticleTypeIntermediaryByarticleId(Integer articleId);
    //查询对应文章的类型
    List<Integer> queryArticleCorrespondingType(Integer articleId);
    //删除对类型的Id
    int deleteArticleTypeIntermediaryByatypeId(Integer atypeId);
}
