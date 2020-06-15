package com.qyc.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.qyc.bean.Student;
import com.qyc.mapper.StudentMapper;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qyc
 * @time 2020/6/15 - 15:44
 */
@Service
public class StudentService {
    @Resource
    private StudentMapper mapper;

    public void install(Student student){
        mapper.insert(student);
    }
    public void delete(String name){
        mapper.delete(name);
    }
    public void update(Student student){
        mapper.update(student);
    }
    public Student select(String name){
        Student student = null;
        try{
            student = mapper.select(name);
        }catch (NullPointerException e){
//            student = new Student(name,-1);
        }
        return student;
    }

    public List<Student> selectAll(){
        return mapper.selectAll();
    }
}
