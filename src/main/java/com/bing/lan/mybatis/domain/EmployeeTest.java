package com.bing.lan.mybatis.domain;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/4/24.
 */

public class EmployeeTest {

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("xiaohong");
        employee.setTelephone("123456789");
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtil.openSession();
            // 老版本 通过xml命名空间调用
            sqlSession.insert("com.bing.lan.mybatis.domain.EmployeeMapper.save", employee);

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
        employee.setTelephone("2222123456789");
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
        Employee employee = sqlSession.selectOne(
                "com.bing.lan.mybatis.domain.EmployeeMapper.get", 3l);

        //EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //mapper.get(2l);

        System.out.println("testGet(): " + employee);
    }

    @Test
    public void testListAll() {
        SqlSession sqlSession = MybatisUtil.openSession();
        //List<Employee> employees = sqlSession.selectList(
        //        "com.bing.lan.mybatis.domain.EmployeeMapper.listAll");

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.listAll();
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testList() {
        SqlSession sqlSession = MybatisUtil.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        mapper.list(new RowBounds(0, 10));
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试一级缓存, 同一个sqlSession查询两次, 实际查询数据库一次
     * 缓存 实际返回的结果(不是sql返回的结果)
     * <p>
     * 获取缓存在 BaseExecutor.query 方法中
     * list = resultHandler == null ? (List<E>) localCache.getObject(key) : null;
     */
    @Test
    public void tesCache1() {
        SqlSession sqlSession = MybatisUtil.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.list(new RowBounds(0, 3));
        /**
         * mybatis自带的分页，是根据 [sql] 查询出结果再分页----->逻辑分页
         * 查询出结果不会全部打印出来, 执行一次ResultSet.next打印一条，
         * 在 FastResultSetHandler.skipRows/shouldProcessMoreRows方法中
         *
         * DEBUG [main] - ==>  Preparing: SELECT * FROM employee
         * DEBUG [main] - ==> Parameters:
         * TRACE [main] - <==    Columns: id, name, phone
         * TRACE [main] - <==        Row: 1, xiaohong, 123456789
         * TRACE [main] - <==        Row: 2, xiaohong, 123456789
         * TRACE [main] - <==        Row: 3, xiaohong, null
         * TRACE [main] - <==        Row: 4, xiaohong, null
         */
        list = mapper.list(new RowBounds(0, 3));

        sqlSession.commit();//提交后才缓存到二级缓存

        //list = mapper.list(new RowBounds(0, 3));//提交后, 关闭前还能再次查询, 此时是从二级缓存获取了

        sqlSession.close();//关闭后一级缓存失效
    }

    /**
     * 测试二级缓存
     * <p>
     * 获取缓存在 CachingExecutor.query方法中
     * List<E> cachedList = (List<E>) cache.getObject(key);
     */
    @Test
    public void tesCache2() {
        SqlSession sqlSession = MybatisUtil.openSession();

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        //List<Employee> list = mapper.list(RowBounds.DEFAULT);
        List<Employee> list = mapper.list(new RowBounds(0, 3));

        sqlSession.commit();
        sqlSession.close();//关闭后一级缓存失效

        sqlSession = MybatisUtil.openSession();
        mapper = sqlSession.getMapper(EmployeeMapper.class);

        list = mapper.list(new RowBounds(0, 3));//只打印了一次sql

        sqlSession.commit();
        sqlSession.close();
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
