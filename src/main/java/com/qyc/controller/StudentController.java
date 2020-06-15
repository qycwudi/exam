package com.qyc.controller;

import com.qyc.bean.Student;
import com.qyc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author qyc
 * @time 2020/6/15 - 15:47
 */
@Controller
//@RestController
public class StudentController {

    @Resource
    private StudentService studentService;
    @PostMapping("/exam/insert")
    public String insert(Student student){
        System.out.println(student.toString());
        studentService.install(student);
        return "成功";
    }

    @GetMapping("/exam/delete/{student}")
    public String delete(@PathVariable("student") String name){
        studentService.delete(name);
        return "redirect:/page/1";
    }

    @PostMapping("/exam/update")
    public String update(Student student){
        System.out.println(student.toString());
        studentService.update(student);
        return "redirect:/page/1";
    }

    @GetMapping("/exam/updateimp/{name}")
    public String updateimp( @PathVariable("name") String names, Map<String,Object> map){
        Student s = studentService.select(names);
        System.out.println(s.toString());
        map.put("student",s);
        return "update";
    }

    @PostMapping("/exam/select/{name}")
    public String test(@PathVariable("name") String names){

        studentService.select(names);
        return "select成功";
    }


    @ResponseBody
    @PostMapping("/selectById")
    public Student  selectById(@RequestBody Student student){

        Student s = studentService.select(student.getName());
        System.out.println(s);
//                if(s==null){
//                    return s;
//                }
        return s;
    }
}
