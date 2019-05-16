package com.bing.lan.mybatis.domain;

import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface EmployeeMapper {

    void save(Employee e);

    void delete(Long id);

    //@Select("select 1")
    void update(Employee e);

    Employee get(Long id);

    List<Employee> listAll();

    List<Employee> list(RowBounds rb);
}
