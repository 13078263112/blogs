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
 * @date 2019/12/22 3:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo implements Serializable {
    private Integer commentId;
    private  String commenConten;
    private  String adminName;
    private  String articleTitle;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date commenCreateTime;
}
