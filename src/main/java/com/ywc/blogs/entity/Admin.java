package com.ywc.blogs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**用户实体类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/14 10:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {

    private Integer adminId;
    private  String adminName;
    private  String password;
    private  Integer adminStatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date adminCreateTime;
}
