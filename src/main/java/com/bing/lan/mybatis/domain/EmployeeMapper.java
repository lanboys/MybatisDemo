package com.bing.lan.mybatis.domain;

import java.util.List;

public interface EmployeeMapper {

    void save(Employee e);

    void delete(Long id);

    void update(Employee e);

    Employee get(Long id);

    List<Employee> list();
}
