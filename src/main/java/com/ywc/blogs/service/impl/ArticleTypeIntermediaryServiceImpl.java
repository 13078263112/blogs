package com.ywc.blogs.service.impl;

import com.ywc.blogs.mapper.ArticleTypeIntermediaryMapper;
import com.ywc.blogs.service.ArticleTypeIntermediaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**文章类型对应表业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 23:01
 */
@Service
public class ArticleTypeIntermediaryServiceImpl implements ArticleTypeIntermediaryService {
    @Autowired
    private ArticleTypeIntermediaryMapper articleTypeIntermediaryMapper;
    @Override
    public int insertArticleTypeIntermediary(Integer articleId, Integer articleTypeId) {
        return articleTypeIntermediaryMapper.insertArticleTypeIntermediary(articleId,articleTypeId);
    }

    @Override
    public int deleteArticleTypeIntermediaryByarticleId(Integer articleId) {
        return articleTypeIntermediaryMapper.deleteArticleTypeIntermediaryByarticleId(articleId);
    }

    @Override
    public List<Integer> queryArticleCorrespondingType(Integer articleId) {
        return articleTypeIntermediaryMapper.queryArticleCorrespondingType(articleId);
    }

    @Override
    public int deleteArticleTypeIntermediaryByatypeId(Integer atypeId) {
        return articleTypeIntermediaryMapper.deleteArticleTypeIntermediaryByatypeId(atypeId);
    }
}
