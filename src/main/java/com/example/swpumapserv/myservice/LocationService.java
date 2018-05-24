package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.mapper.LocationMapper;
import com.example.swpumapserv.mapper.UserMapper;
import com.example.swpumapserv.utils.CyWebException;
import com.example.swpumapserv.utils.Pkutils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-17 18:35
 **/
@Service
public class LocationService extends BaseService {


    Gson gson = new Gson();
    final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    LocationMapper locationMapper;
    @Autowired
    UserMapper userMapper;

    public  void  addLocation(String account,String location_desc, BigDecimal longitude , BigDecimal  latitude ) throws CyWebException
    {


        LocationEntity  locationEntity = new LocationEntity();
        UserEntity userEntity =userMapper.findUser(account);

        locationEntity.setId(Pkutils.getUUID());
        locationEntity.setAccount(userEntity.getAccount());
        locationEntity.setLongitude(longitude);
        locationEntity.setLatitude(latitude);
        locationEntity.setStudentno(userEntity.getStudentno());
        locationEntity.setLocation_desc(location_desc);
        locationEntity.setCollect_date(new Date());
        locationMapper.addLocation(locationEntity);

    }

    public  List<LocationEntity> findByaccount( String account)
    {
        return  locationMapper.findByaccount(account);
    }
}
