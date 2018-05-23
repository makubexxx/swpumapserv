package com.example.swpumapserv.controller;

import com.example.swpumapserv.base.BaseController;
import com.example.swpumapserv.myservice.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 11:56
 **/
@Controller
@RequestMapping("/lvqinglong/v1/user")
public class UserController extends BaseController{


    @Autowired
    UserService userService;

    //注册
    @RequestMapping(value = "/register", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody String register(HttpServletRequest request, HttpServletResponse response,
                                       String studentno, String account ,String passsword ) throws  Exception
    {

       int result =userService.addUser(studentno,account,passsword);
       return toJson(result, request, response);
    }


    //登录
    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody String login(HttpServletRequest request, HttpServletResponse response,
                                        String username,String passsword) throws  Exception
    {

        int result =userService.login(username,passsword);
        return toJson(result, request, response);
    }

}
