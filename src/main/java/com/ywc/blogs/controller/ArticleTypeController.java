package com.ywc.blogs.controller;

import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.service.ArticleTypeIntermediaryService;
import com.ywc.blogs.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**文章类型控制器
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/19 1:38
 */
@RestController
@RequestMapping("/articleType")
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;
    @Autowired
    private ArticleTypeIntermediaryService articleTypeIntermediaryService;
    //查询所有的文章类型
    @GetMapping("/articleTypeAll")
    public Map<String,Object> queryAllArticleType(){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleTypeService.queryAllArticleType());
        return map ;
    }
    //分页查询文章类型
    @GetMapping("/articleTypeAllPaging")
    public Map<String,Object> queryAllArticleTypePaging(Integer pageNo,Integer pageSize) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleTypeService.queryAllArticleTypePaging(pageNo,pageSize));
        return map ;
    }
    //根据类型ID来删除
    @PostMapping ("/deleteArticleId")
    public Map<String,Object> deleteArticleTypeByAtypeId(@RequestBody List<Integer> atypeId) {
        for (Integer integer : atypeId) {
            articleTypeService.deleteArticleTypeByAtypeId(integer);
            articleTypeIntermediaryService.deleteArticleTypeIntermediaryByatypeId(integer);
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","删除成功");
        return map ;
    }
    //后台修改文章类型
    @PostMapping("/updateArticleType")
    public Map<String,Object> updateArticleByArticleId(ArticleType articleType,@RequestBody Map<String,Object> maps) {
        articleType.setAtypeId(Integer.valueOf((String) maps.get("atypeId")));
        articleType.setAtypeName((String) maps.get("atypeName"));
        int i = articleTypeService.updateArticleType(articleType);
        Map<String,Object> map=new HashMap<String,Object>();
        if (i==1){
            map.put("result ","200");
            map.put("msg","修改成功");
        }else {
            map.put("result ","200");
            map.put("msg","修改失败");
        }
        return map ;
    }
    //后台根据Id来查询
    @GetMapping("/articleTypeAllById")
    public Map<String,Object> queryAllArticleTypeByAtypeId(Integer atypeId) {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleTypeService.queryAllArticleTypeByAtypeId(atypeId));
        return map ;
    }
    //后台添加文章类型
    @PostMapping("/InsertarticleType")
    public Map<String,Object> insertArticleType(@RequestBody Map<String,Object> maps) {
        articleTypeService.insertArticleType((String) maps.get("atypeName"));
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","添加成功");
        return map ;
    }
    //前台查询类型和文章数量
    @GetMapping("/queryArticleByAtypenameCount")
    public Map<String,Object> queryAllArticleByAtypenameCount() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("result ","200");
        map.put("msg","查询成功");
        map.put("list",articleTypeService.queryAllArticleByAtypenameCount());
        return map ;
    }
}
