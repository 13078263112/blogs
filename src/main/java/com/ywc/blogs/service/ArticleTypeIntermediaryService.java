package com.ywc.blogs.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**文章类型对应表业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 23:00
 */

public interface ArticleTypeIntermediaryService {
    int insertArticleTypeIntermediary(Integer articleId, Integer articleTypeId);
    int deleteArticleTypeIntermediaryByarticleId(Integer articleId);
    //所有的文章类型
    List<Integer> queryArticleCorrespondingType(Integer articleId);
    //删除对类型的Id
    int deleteArticleTypeIntermediaryByatypeId(Integer atypeId);
}
