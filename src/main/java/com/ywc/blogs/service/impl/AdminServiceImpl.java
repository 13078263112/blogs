package com.ywc.blogs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ywc.blogs.entity.Admin;
import com.ywc.blogs.entity.ArticleType;
import com.ywc.blogs.mapper.AdminMapper;
import com.ywc.blogs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**admin业务逻辑层实现类
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/16 16:28
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin queryAdminByNameAndpassword(Admin admin) {
        return adminMapper.queryAdminByNameAndpassword(admin);
    }

    @Override
    public int queryAdminByNum() {
        return adminMapper.queryAdminByNum();
    }

    @Override
    public int updateAdminByIdAndpassword(Admin admin) {
        return adminMapper.updateAdminByIdAndpassword(admin);
    }

    @Override
    public PageInfo<Admin> queryAdminPaging(Integer pageNo, Integer pageSize) {
        Page<Map<String, String>> objects = PageHelper.startPage(pageNo, pageSize);
        List<Admin> admins = adminMapper.queryAdmin();
        PageInfo<Admin> pageInfo=new PageInfo<Admin>(admins);
        return pageInfo;
    }

    @Override
    public int updateAdminByIdAndAdminStatus(Admin admin) {
        return adminMapper.updateAdminByIdAndAdminStatus(admin);
    }
}
