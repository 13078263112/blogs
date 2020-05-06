package com.ywc.blogs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**文章类型实体类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 10:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleType  implements Serializable {
    private Integer atypeId;
    private  String atypeName;
}
