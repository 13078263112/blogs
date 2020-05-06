package com.ywc.blogs.service;

import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.vo.ArticleVo;

import java.util.List;
import java.util.Map;

/**文章类型业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 1:36
 */
public interface ArticleTypeService {
    //查询所有文章类型
    List<ArticleType> queryAllArticleType();
    //分页查询所有文章类型
    PageInfo<ArticleType> queryAllArticleTypePaging(Integer pageNo, Integer pageSize);
    //根据类型ID来删除
    int deleteArticleTypeByAtypeId(Integer atypeId);
    //根据id来查询
    ArticleType queryAllArticleTypeByAtypeId(Integer atypeId);
    //修改
    int updateArticleType(ArticleType articleType);
    //文章类型添加
    int  insertArticleType(String atypeName);
    //查询文章类型和对应的文章数量
    List<Map<String,String>>  queryAllArticleByAtypenameCount();
}
