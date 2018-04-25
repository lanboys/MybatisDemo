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
            //sqlSession.insert("com.bing.lan.mybatis.domain.EmployeeMapper.save", employee);

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.save(employee);

            sqlSession.commit();
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

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("xiaoho2ng");
        employee.setPhone("2222123456789");
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSession();
            //sqlSession.insert("com.bing.lan.mybatis.domain.EmployeeMapper.update", employee);

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.update(employee);

            sqlSession.commit();
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

    @Test
    public void testGet() {
        SqlSession sqlSession = MybatisUtil.openSession();
        //Employee employee = sqlSession.selectOne(
        //        "com.bing.lan.mybatis.domain.EmployeeMapper.get", 2l);

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.get(2l);
    }

    @Test
    public void testList() {
        SqlSession sqlSession = MybatisUtil.openSession();
        //List<Employee> employees = sqlSession.selectList(
        //        "com.bing.lan.mybatis.domain.EmployeeMapper.list");

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.list();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSession();
            //sqlSession.delete(
            //        "com.bing.lan.mybatis.domain.EmployeeMapper.delete", 2l);

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.delete(2l);

            sqlSession.commit();
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
