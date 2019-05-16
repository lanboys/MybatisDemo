package com.bing.lan.mybatis.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by 蓝兵 on 2018/4/25.
 */

public class MybatisUtil {

    private static volatile MybatisUtil instance;
    private static SqlSessionFactory sessionFactory;

    private MybatisUtil() {
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("sessionFactory 为null");
        }
    }

    public static MybatisUtil getInstance() {
        if (instance == null) {
            synchronized (MybatisUtil.class) {
                if (instance == null) {
                    instance = new MybatisUtil();
                }
            }
        }
        return instance;
    }

    public static SqlSession openSession() {
        if (sessionFactory == null) {
            getInstance();
        }
        return sessionFactory.openSession();
    }
}
