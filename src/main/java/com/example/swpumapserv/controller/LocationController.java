package com.example.swpumapserv.controller;

import com.example.swpumapserv.base.BaseController;
import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.myservice.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-17 18:33
 **/
@Controller
@RequestMapping("/lvqinglong/v1/location")
public class LocationController extends BaseController{

    @Autowired
    LocationService  locationService;
    //添加
    @RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String addLocation(HttpServletRequest request, HttpServletResponse response,
                      String account,String location_desc, BigDecimal longitude , BigDecimal  latitude) throws  Exception
    {

        locationService.addLocation(account,location_desc,longitude,latitude);
        return toJson("success", request, response);
    }

    //添加
    @RequestMapping(value = "/findall", method = { RequestMethod.POST, RequestMethod.GET })
    public  @ResponseBody
    String addStudent(HttpServletRequest request, HttpServletResponse response,
                      String account)
    {

        List<LocationEntity> list = locationService.findByaccount(account);
        return toJson(list, request, response);
    }

}
