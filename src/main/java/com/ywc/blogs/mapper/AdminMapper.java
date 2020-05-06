package com.ywc.blogs.mapper;

import com.ywc.blogs.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/** 博主dao层
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/16 16:14
 */
@Repository
@Mapper
public interface AdminMapper {
    //根据名称和密码来查询
    Admin queryAdminByNameAndpassword(Admin admin);
    //查询管理个数
    int queryAdminByNum();
    //修改密码
    int updateAdminByIdAndpassword(Admin admin);
    //查询所有用户
    List<Admin> queryAdmin();
    //修改用户状态
    int updateAdminByIdAndAdminStatus(Admin admin);
}
