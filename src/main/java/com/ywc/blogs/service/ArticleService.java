package com.ywc.blogs.service;

import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.Article;
import com.ywc.blogs.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

/**文章业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 11:17
 */
public interface ArticleService {
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
    PageInfo<Map<String, String>> queryArticleAllByTypeAndSort( String aTypeName,String sort,Integer pageNum,Integer pageSize);
    //后台查询没有删除文章信息
    PageInfo<ArticleVo>  queryArticleAllArticleVo(Integer pageNo,Integer pageSize);
    //后台查询删除文章信息
    PageInfo<ArticleVo>   queryArticleAllDeleteArticleVo(Integer pageNo,Integer pageSize);
    //修改文章是否推荐
    int updateArticleByIsrecommend(Integer articleId,Integer articleIsrecommend);
    //修改文章是否置顶
    int updateArticleByIsoriginal(Integer articleId,Integer articleIsoriginal);
    //删除文章就是修改article_isdelete
    int updateArticleByIsdelete(Integer articleId,Integer articleIsdelete);
    //插入文章
    int insertArticle(Article article);
    //彻底删除文章
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
