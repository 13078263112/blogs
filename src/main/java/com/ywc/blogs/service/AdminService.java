package com.ywc.blogs.service;

import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.Admin;

import java.util.List;

/**admin业务逻辑层接口
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/16 16:27
 */
public interface AdminService {
    //根据名称和密码来查询
    Admin queryAdminByNameAndpassword(Admin admin);
    //查询管理个数
    int queryAdminByNum();
    //修改密码
    int updateAdminByIdAndpassword(Admin admin);
    //分页查询所有用户
    PageInfo<Admin> queryAdminPaging(Integer pageNo, Integer pageSize);
    //修改用户状态
    int updateAdminByIdAndAdminStatus(Admin admin);
}
