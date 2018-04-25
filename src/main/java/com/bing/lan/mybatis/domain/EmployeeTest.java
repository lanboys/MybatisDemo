package com.bing.lan.mybatis.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

public class EmployeeTest {

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("xiaohong");
        employee.setPhone("123456789");
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSession();
            sqlSession.insert("com.bing.lan.mybatis.domain.EmployeeMapper.save", employee);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
