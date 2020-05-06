package com.ywc.blogs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**文章实体类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article implements Serializable {
    private  Integer articleId;
    //文章标题
    private  String articleTitle;
    //文章关键字
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
    //文章是否删除
    private  Integer articleIsdelete;
    //文章是否是原创建
    private  Integer articleIsoriginal;
    //文章是否推荐
    private  Integer articleIsrecommend;
    //文章作者信息
    private  Admin admin;
    //文章对应多个类型
    private List<ArticleType> articleTypes;
}
