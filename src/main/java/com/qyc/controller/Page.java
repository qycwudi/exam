package com.qyc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyc.bean.Student;
import com.qyc.mapper.StudentMapper;
import com.qyc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author qyc
 * @time 2020/6/15 - 16:13
 */
@Controller
public class Page {
    @Resource
    private StudentService studentService;
    @Resource
    private StudentMapper studentMapper;
    @RequestMapping("page/{num}")
    public String page(@PathVariable("num") Integer nums, Map<String,Object> map){
        if(nums==null||nums<=0){
            nums = 1;
        }

        PageHelper.startPage(nums,2);
        List<Student> list = studentService.selectAll();

        PageInfo pageInfo = new PageInfo(list);
        list = pageInfo.getList();
        if(nums>pageInfo.getPageSize()+1){
            PageHelper.startPage(nums-1,2);
            list = studentService.selectAll();
            pageInfo = new PageInfo(list);
        }
        map.put("Studentlist",pageInfo.getList());

        int i = pageInfo.getPages();
        List<String> list2 = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list2.add(" ");
        }
        map.put("Studentlist",list);
        map.put("pagelist",list2);
        map.put("now",pageInfo.getPageNum());
        return "show";
    }
}
