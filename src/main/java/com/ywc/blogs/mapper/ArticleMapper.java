package com.ywc.blogs.mapper;

import com.ywc.blogs.entity.Article;
import com.ywc.blogs.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**文章dao层
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 10:47
 */
@Repository
@Mapper
public interface ArticleMapper {
    //查询所有的文章
    List<Article> queryArticleAll();
    //查询前六条原创的文章标题
    List<Map<String,String>> queryArticleAllByIsoriginal();
    //查询前六条推荐文章的标题
    List<Map<String,String>> queryArticleAllByIsrecommend();
    //查询前六条浏览最高文章的标题
    List<Map<String,String>> queryArticleAllByreadnum();
    //查询文章数量
    int queryArticleAllNum();
    //查询文章所有pv量
    int queryArticleAllByreadnumNum();
    //根据文章类型查询前八条文章标题和创建时间
    List<Map<String,String>>  queryArticleAllByType(String aTypeName);
    //查询前七条最新文章
    List<Map<String,String>>  queryArticleAllByNew();
    //根据文章类型查询（默认为时间排序，访问量,评论数）
    List<Map<String,String>> queryArticleAllByTypeAndSort(@Param("aTypeName") String aTypeName, @Param("sort")String sort);
    //后台查询没有删除文章信息
    List<ArticleVo>   queryArticleAllArticleVo();
    //后台查询删除文章信息
    List<ArticleVo>   queryArticleAllDeleteArticleVo();
    //后台修改文章是否推荐
    int updateArticleByIsrecommend(@Param("articleId")Integer articleId,@Param("articleIsrecommend")Integer articleIsrecommend);
    //后台修改文章是否置顶
    int updateArticleByIsoriginal(@Param("articleId")Integer articleId,@Param("articleIsoriginal")Integer articleIsoriginal);
    //后台删除文章就是修改article_isdelete
    int updateArticleByIsdelete(@Param("articleId")Integer articleId,@Param("articleIsdelete")Integer articleIsdelete);
    //后台文章添加
    int insertArticle(Article article);
    //后台彻底删除文章
    int deleteArticleByArticleId(Integer articleId);
    //后台根据Id来查询
    ArticleVo queryArticleByArticleId(Integer articleId);
    //后台修改文章
    int updateArticleByArticleId(Article article);
    //前台查询同类热门文章
    List<Map<String,String>> queryArticleTitleByAtypeId(Integer articleId);
    //前台根据id查询文章信息
    List<Map<String,String>>  queryArticleArticleVoByarticleId(Integer articleId);
}
