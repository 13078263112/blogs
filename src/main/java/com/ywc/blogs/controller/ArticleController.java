package com.ywc.blogs.controller;

import com.ywc.blogs.entity.Admin;
import com.ywc.blogs.entity.Article;
import com.ywc.blogs.service.ArticleService;
import com.ywc.blogs.service.ArticleTypeIntermediaryService;
import com.ywc.blogs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**文章控制器
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 11:23
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTypeIntermediaryService articleTypeIntermediaryService;
    @Autowired
    private CommentService commentService;
    //查询前六条原创的文章标题
    @GetMapping("/isoriginal")
    public Map<String,Object> queryArticleAllByIsoriginal(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByIsoriginal());
        return map ;

    }
    //查询前六条推荐文章的标题
    @GetMapping("/isrecommend")
    public Map<String,Object> queryArticleAllByIsrecommend(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByIsrecommend());
        return map ;
    }
    //查询前六条浏览最高文章的标题
    @GetMapping("/readnum")
    public Map<String,Object> queryArticleAllByreadnum(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByreadnum());
        return map ;
    }
    //查询文章数量
    @GetMapping("/articlenum")
    public Map<String,Object> queryArticleAllNum(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllNum());
        return map ;
    }
    //查询文章所有pv量
    @GetMapping("/readnumNum")
    public Map<String,Object> queryArticleAllByreadnumNum(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByreadnumNum());
        return map ;
    }
    //根据文章类型查询前八条文章标题和创建时间
    @GetMapping("/titleandtime")
    public Map<String,Object> queryArticleAllByType(String aTypeName) throws UnsupportedEncodingException {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByType(new String(aTypeName.getBytes("iso-8859-1"),"utf-8")));
        return map ;
    }
    //查询前七条最新文章
    @GetMapping("/newArticle")
    public Map<String,Object> queryArticleAllByNew()  {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByNew());
        return map ;
    }
    //前台根据文章类型查询（默认为时间排序，访问量,评论数）
    @PostMapping("/queryArticleAtypeNmaeAndSort")
    public Map<String,Object> queryArticleAllByTypeAndSort(@RequestBody Map<String,Object> maps){

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllByTypeAndSort((String) maps.get("aTypeName"),(String) maps.get("sort"), (Integer)maps.get("pageNum"),(Integer)maps.get("pageSize")));
        return map ;
    }
    //后台根据文章查询
    @GetMapping("/adminArticleVo")
    public Map<String,Object> queryArtickeAllArticleVo(Integer pageNo,Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllArticleVo(pageNo,pageSize));
        return map ;
    }
    @GetMapping("/adminDeleteArticleVo")
    public Map<String,Object> queryArticleAllDeleteArticleVo(Integer pageNo,Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleAllDeleteArticleVo(pageNo,pageSize));
        return map ;
    }
    //后台根据id来修改是否推荐
    @GetMapping("/updateIsrecommend")
    public Map<String,Object> updateArticleByIsrecommend(Integer articleId,Integer articleIsrecommend) {
        int i = articleService.updateArticleByIsrecommend(articleId, articleIsrecommend);
        Map<String,Object> map=new HashMap<String,Object>();
        if (i==0){
            map.put("result ","200");
            map.put("msg","修改失败");
        }else{
            map.put("result ","200");
            map.put("msg","修改成功");
        }
        return map ;
    }
    //后台根据id来修改是否置顶
    @GetMapping("/updateIsoriginal")
    public Map<String,Object> updateArticleByIsoriginal(Integer articleId,Integer articleIsoriginal) {
        int i = articleService.updateArticleByIsoriginal(articleId,articleIsoriginal);
        Map<String,Object> map=new HashMap<String,Object>();
        if (i==0){
            map.put("result ","200");
            map.put("msg","修改失败");
        }else{
            map.put("result ","200");
            map.put("msg","修改成功");
        }
        return map ;
    }
    //后台根据id来修改是否删除
    @PostMapping("/updateIsdelete")
    public Map<String,Object> updateArticleByIsdelete(Integer articleIsdelete,@RequestBody List<Integer> articleId) {

        int i=0;
        for (Integer integer : articleId) {
            i+= articleService.updateArticleByIsdelete(integer, articleIsdelete);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        if (i!=articleId.size()){
            map.put("result ","200");
            map.put("msg","修改失败");
        }else{
            map.put("result ","200");
            map.put("msg","修改成功");
        }
        return map ;
    }
    //文章插入
    @PostMapping("/insertArticle")
    public Map<String,Object> insertArticle(Article article,Admin admin,@RequestBody Map<String,Object> maps) {
        article.setArticleTitle((String) maps.get("articletitle"));
        article.setArticleTheme((String) maps.get("articletheme"));
        article.setArticleContent((String) maps.get("articleContent"));
        admin.setAdminId(Integer.valueOf((String) maps.get("adminId")) );
        article.setAdmin(admin);
        article.setArticleIsoriginal(Integer.valueOf((String) maps.get("isrecommend")));
        articleService.insertArticle(article);
        List<String> list = (List<String>) maps.get("articleType");
        for (String integer : list) {
            articleTypeIntermediaryService.insertArticleTypeIntermediary(article.getArticleId(),Integer.valueOf(integer));
        }
        Map<String,Object> map=new HashMap<String,Object>();
            map.put("result ","200");
            map.put("msg","添加成功");
        return map ;
    }
    //后台根据id来修改是否彻底删除
    @GetMapping("/deleteArticle")
    public Map<String,Object> deleteArticleByArticleId(Integer articleId) {
        int i = articleService.deleteArticleByArticleId(articleId);
        articleTypeIntermediaryService.deleteArticleTypeIntermediaryByarticleId(articleId);
        commentService.deleteCommentByarticleId(articleId);
        Map<String,Object> map=new HashMap<String,Object>();
        if (i==0){
            map.put("result ","200");
            map.put("msg","修改失败");
        }else{
            map.put("result ","200");
            map.put("msg","修改成功");
        }
        return map ;
    }
    //后台根据id查询数据
    @GetMapping("/queryArticleId")
    public Map<String,Object> queryArticleByArticleId(Integer articleId) {
        System.out.println(articleId);
        Map<String,Object> map=new HashMap<String,Object>();
            map.put("result ","200");
            map.put("msg","查询成功");
             map.put("list",articleService.queryArticleByArticleId(articleId));
        map.put("list1",articleTypeIntermediaryService.queryArticleCorrespondingType(articleId));
        return map ;
    }
    @PostMapping("/updateArticle")
    public Map<String,Object> updateArticleByArticleId(Article article,@RequestBody Map<String,Object> maps){
        article.setArticleId(Integer.valueOf((String) maps.get("articleId")));
            article.setArticleTitle((String) maps.get("articletitle"));
        article.setArticleTheme((String) maps.get("articletheme"));
        article.setArticleContent((String) maps.get("articleContent"));
        Map<String,Object> map=new HashMap<String,Object>();
        int i = articleService.updateArticleByArticleId(article);
        //类型删除
        articleTypeIntermediaryService.deleteArticleTypeIntermediaryByarticleId(Integer.valueOf((String) maps.get("articleId")));
        List<String> list = (List<String>) maps.get("articleType");
        for (String integer : list) {
            articleTypeIntermediaryService.insertArticleTypeIntermediary(article.getArticleId(),Integer.valueOf(integer));
        }
        if (i==1){
            map.put("result ","200");
            map.put("msg","修改成功");
        }else {
            map.put("result ","200");
            map.put("msg","修改失败");
        }

        return map ;
    }
    //前台根据id相对应的文章
    @GetMapping("/queryArticleIdByType")
    public Map<String,Object> queryArticleTitleByAtypeId(Integer articleId) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleTitleByAtypeId(articleId));
        return map ;
    }
    //前台根据id获取文章信息
    @GetMapping("/queryArticleIdById")
    public Map<String,Object> queryArticleArticleVoByarticleId(Integer articleId) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleService.queryArticleArticleVoByarticleId(articleId));

        return map ;
    }
}
