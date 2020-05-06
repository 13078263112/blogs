package com.ywc.blogs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/22 4:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentAuditVo  implements Serializable {
    private Integer commentauditId;
    private  String commentauditConten;
    private  String adminName;
    private Integer articleId;
    private  String articleTitle;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date commentauditCreateTime;
}
