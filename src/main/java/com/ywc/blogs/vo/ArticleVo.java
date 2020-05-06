package com.ywc.blogs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ywc.blogs.entity.Admin;
import com.ywc.blogs.entity.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 嘟嘟~~
 * @date 2019/12/17 19:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVo implements Serializable {
    private  Integer articleId;
    //文章标题
    private  String articleTitle;
    //文章标题
    private  String articleTheme;
    //文章内容
    private  String articleContent;
    //文章浏览量
    private  Integer articleReadnum;
    //文章创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date articleCreationtime;
    //文章最近修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date articleUpdatetime;
    //作者名称
    private  String adminName;
    //文章是否是原创建
    private  Integer articleIsoriginal;
    //文章是否推荐
    private  Integer articleIsrecommend;

}
