package com.ywc.blogs.mapper;


import com.ywc.blogs.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author 嘟嘟~
 * @version 1.0
 * @date 2019/12/16 16:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminMapperTest {
    @Autowired
    private  AdminMapper adminMapper;

    @Test
    public void queryAdminByNameAndpassword() {
        Admin admin=new Admin();
        admin.setAdminName("admin");
        admin.setPassword("admin");
        Admin admin1 = adminMapper.queryAdminByNameAndpassword(admin);
        System.out.println(admin1);

    }

}
