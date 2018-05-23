package com.example.swpumapserv.controller;

import com.example.swpumapserv.base.BaseController;
import com.example.swpumapserv.entity.StudentEntity;
import com.example.swpumapserv.myservice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-23 15:03
 **/
@Controller
@RequestMapping("/lvqinglong/v1/student")
public class StudentController extends BaseController {

    @Autowired
    StudentService studentService;
    //添加
    @RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String addStudent(HttpServletRequest request, HttpServletResponse response,
                    String account ) throws  Exception
    {

        studentService.addStudent(account);
        return toJson("success", request, response);
    }
    //添加
    @RequestMapping(value = "/findall", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String findallStudent(HttpServletRequest request, HttpServletResponse response) throws  Exception
    {

        List<StudentEntity> list=studentService.findall();
        return toJson(list, request, response);
    }
}
