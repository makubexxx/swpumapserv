package com.example.swpumapserv.controller;

import com.example.swpumapserv.base.BaseController;
import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.MarkEntity;
import com.example.swpumapserv.myservice.MarkService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 07:32
 **/
@Controller
@RequestMapping("/lvqinglong/v1/mark")
public class MarkController extends BaseController {

    @Autowired
    MarkService markService;
    //添加
    @RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String addStudent(HttpServletRequest request, HttpServletResponse response,
                      MarkEntity markEntity ) throws  Exception
    {

        markService.addMark(markEntity);
        return toJson("success", request, response);
    }

    @RequestMapping(value = "/findall", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String addStudent(HttpServletRequest request, HttpServletResponse response,
                      String account)
    {

        List<MarkEntity> list = markService.findall(account);
        if (list.size()==0)
        {
            return toJson("null", request, response);
        }
        return toJson(list, request, response);
    }

}
