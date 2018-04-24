package com.bing.lan.mybatis.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

public class EmployeeTest {

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("xiaohong");
        employee.setPhone("123456789");

        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("mybatis-config.xml"));
            SqlSession sqlSession = factory.openSession();
            sqlSession.insert("com.bing.lan.mybatis.domain.EmployeeMapper.save", employee);

            sqlSession.commit();
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
