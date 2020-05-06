package com.ywc.blogs.mapper;

import com.ywc.blogs.entity.ArticleType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**文章类型dao层
 * @author 嘟嘟~~
 * @date 2019/12/18 21:37
 */
@Repository
@Mapper
public interface ArticleTypeMapper {
    //查询所有文章类型
    List<ArticleType> queryAllArticleType();
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
