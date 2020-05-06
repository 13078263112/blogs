package com.ywc.blogs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.mapper.ArticleTypeMapper;
import com.ywc.blogs.service.ArticleTypeService;
import com.ywc.blogs.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**文章类型业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 1:36
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Override
    public List<ArticleType> queryAllArticleType() {
        return articleTypeMapper.queryAllArticleType();
    }

    @Override
    public PageInfo<ArticleType> queryAllArticleTypePaging(Integer pageNo, Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<ArticleType> articleTypes = articleTypeMapper.queryAllArticleType();
        PageInfo<ArticleType> pageInfo=new PageInfo<ArticleType>(articleTypes);
        return pageInfo;
    }

    @Override
    public int deleteArticleTypeByAtypeId(Integer atypeId) {
        return articleTypeMapper.deleteArticleTypeByAtypeId(atypeId);
    }

    @Override
    public ArticleType queryAllArticleTypeByAtypeId(Integer atypeId) {
        return articleTypeMapper.queryAllArticleTypeByAtypeId(atypeId);
    }

    @Override
    public int updateArticleType(ArticleType articleType) {
        return articleTypeMapper.updateArticleType(articleType);
    }

    @Override
    public int insertArticleType(String atypeName) {
        return articleTypeMapper.insertArticleType(atypeName);
    }

    @Override
    public List<Map<String, String>> queryAllArticleByAtypenameCount() {
        return articleTypeMapper.queryAllArticleByAtypenameCount();
    }
}
