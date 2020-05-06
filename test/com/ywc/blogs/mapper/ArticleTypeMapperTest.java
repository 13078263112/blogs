package com.ywc.blogs.mapper;

import com.ywc.blogs.entity.ArticleType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 1:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ArticleTypeMapperTest {
    @Autowired
    private  ArticleTypeMapper articleTypeMapper;
    @Test
    public void  queryAllArticleType(){
        List<ArticleType> articleTypes = articleTypeMapper.queryAllArticleType();
        for (ArticleType articleType : articleTypes) {
            System.out.println(articleType);
        }
    }
    @Test
    public void  queryAllArticleByAtypenameCount(){
        List<Map<String, String>> maps = articleTypeMapper.queryAllArticleByAtypenameCount();
        for (Map<String, String> map : maps) {
            System.out.println(map);
        }

    }
}
