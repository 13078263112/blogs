package com.ywc.blogs.mapper;


import com.ywc.blogs.entity.Admin;
import com.ywc.blogs.entity.Article;

import com.ywc.blogs.vo.ArticleVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 11:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ArticleMapperTest {
    @Autowired
    private  ArticleMapper articleMapper;
    @Test
    public void  queryArticleAll() {
        List<Article> articles = articleMapper.queryArticleAll();
        System.out.println(articles);
    }
    @Test
    public void  queryArticleAllByIsoriginal() {
        List<Map<String, String>> strings = articleMapper.queryArticleAllByIsoriginal();
        System.out.println(strings);
    }
    @Test
    public void  queryArticleAllByreadnumNum() {

        System.out.println(articleMapper.queryArticleAllByreadnumNum());
    }
    @Test
    public void  queryArticleAllByType() {

        List<Map<String, String>> list = articleMapper.queryArticleAllByType("编程分享");
        System.out.println(list);
    }
    @Test
    public void  queryArticleAllByTypeAndSort() {
        List<Map<String, String>> list = articleMapper.queryArticleAllByTypeAndSort("程序人生", "时间");
        System.out.println(list.toString());
    }
    @Test
    public void  queryArtickeAllArticleVo() {
        List<ArticleVo> articleVos = articleMapper.queryArticleAllArticleVo();
        System.out.println(articleVos);
    }
    @Test
    public void  updateArticleByIsdelete() {
       articleMapper.updateArticleByIsdelete(1001,1);
    }
    @Test
    public void  insertArticle() throws ParseException {
        Article article =new Article();
        article.setArticleTitle("a");
        article.setArticleTheme("a");
        article.setArticleContent("a");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        article.setArticleCreationtime(dateformat.parse(dateformat.format(new Date())));
        article.setArticleUpdatetime(dateformat.parse(dateformat.format(new Date())));
        Admin admin = new Admin();
        admin.setAdminId(1001);
        article.setAdmin(admin);
        article.setArticleIsoriginal(1);
        int i = articleMapper.insertArticle(article);
        System.out.println(article);
    }
    @Test
    public void  queryArticleByArticleId() {
        ArticleVo articleVo = articleMapper.queryArticleByArticleId(1002);
        System.out.println(articleVo);

    }

    @Test
    public void  queryArticleTitleByAtypeId() {
        List<Map<String, String>> maps = articleMapper.queryArticleTitleByAtypeId(1001);
        System.out.println(maps);
    }
}
