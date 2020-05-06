package com.ywc.blogs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.Article;
import com.ywc.blogs.mapper.ArticleMapper;
import com.ywc.blogs.service.ArticleService;
import com.ywc.blogs.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**文章业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 11:21
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Map<String,String>> queryArticleAllByIsoriginal() {
        return articleMapper.queryArticleAllByIsoriginal();
    }

    @Override
    public List<Map<String,String>> queryArticleAllByIsrecommend() {
        return articleMapper.queryArticleAllByIsrecommend();
    }

    @Override
    public List<Map<String,String>> queryArticleAllByreadnum() {
        return articleMapper.queryArticleAllByreadnum();
    }

    @Override
    public int queryArticleAllNum() {
        return articleMapper.queryArticleAllNum();
    }

    @Override
    public int queryArticleAllByreadnumNum() {
        return articleMapper.queryArticleAllByreadnumNum();
    }
    @Override
    public List<Map<String, String>> queryArticleAllByType(String aTypeName) {
        return articleMapper.queryArticleAllByType(aTypeName);
    }
    @Override
    public List<Map<String, String>> queryArticleAllByNew() {
        return articleMapper.queryArticleAllByNew();
    }

    @Override
    public PageInfo<Map<String, String>> queryArticleAllByTypeAndSort(String aTypeName, String sort,Integer pageNum,Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNum, pageSize);
        List<Map<String, String>> maps = articleMapper.queryArticleAllByTypeAndSort(aTypeName, sort);
        PageInfo<Map<String, String>> pageInfo=new PageInfo<Map<String, String>>(maps);
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleVo> queryArticleAllArticleVo(Integer pageNo,Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<ArticleVo> articleVos = articleMapper.queryArticleAllArticleVo();
        PageInfo<ArticleVo> pageInfo=new PageInfo<ArticleVo>(articleVos);
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleVo> queryArticleAllDeleteArticleVo(Integer pageNo, Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<ArticleVo> articleVos = articleMapper.queryArticleAllDeleteArticleVo();
        PageInfo<ArticleVo> pageInfo=new PageInfo<ArticleVo>(articleVos);
        return pageInfo;
    }

    @Override
    public int updateArticleByIsrecommend(Integer articleId, Integer articleIsrecommend) {
        return articleMapper.updateArticleByIsrecommend(articleId,articleIsrecommend);
    }

    @Override
    public int updateArticleByIsoriginal(Integer articleId, Integer articleIsoriginal) {
        return articleMapper.updateArticleByIsoriginal(articleId,articleIsoriginal);
    }

    @Override
    public int updateArticleByIsdelete(Integer articleId, Integer articleIsdelete) {
        return articleMapper.updateArticleByIsdelete(articleId,articleIsdelete);
    }

    @Override
    public int insertArticle(Article article) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            article.setArticleCreationtime(dateformat.parse(dateformat.format(new Date())));
            article.setArticleUpdatetime(dateformat.parse(dateformat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleMapper.insertArticle(article) ;
    }

    @Override
    public int deleteArticleByArticleId(Integer articleId) {
        return articleMapper.deleteArticleByArticleId(articleId);
    }

    @Override
    public ArticleVo queryArticleByArticleId(Integer articleId) {
        return articleMapper.queryArticleByArticleId(articleId);
    }

    @Override
    public int updateArticleByArticleId(Article article) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            article.setArticleUpdatetime(dateformat.parse(dateformat.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return articleMapper.updateArticleByArticleId(article);
    }

    @Override
    public List<Map<String, String>> queryArticleTitleByAtypeId(Integer articleId) {
        return articleMapper.queryArticleTitleByAtypeId(articleId);
    }

    @Override
    public List<Map<String, String>> queryArticleArticleVoByarticleId(Integer articleId) {
        return articleMapper.queryArticleArticleVoByarticleId(articleId);
    }
}
