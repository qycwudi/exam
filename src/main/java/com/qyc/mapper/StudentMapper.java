package com.qyc.mapper;

import com.qyc.bean.Student;

import java.util.List;

/**
 * @author qyc
 * @time 2020/6/15 - 15:45
 */
public interface StudentMapper {
    public void insert(Student student);
    public void delete(String name);
    public void update(Student student);
    public Student select(String names);
    public List<Student> selectAll();
}
