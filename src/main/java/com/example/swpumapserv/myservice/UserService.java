package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.controller.UserController;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.mapper.UserMapper;
import com.example.swpumapserv.utils.CyWebException;
import com.example.swpumapserv.utils.Pkutils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 14:08
 **/
@Service
public class UserService extends BaseService {
    Gson gson = new Gson();
    final static Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserMapper userMapper;

    public  void  addUser(String str) throws CyWebException
    {
        logger.info(str);
        //解析ajax 或者android 传过来的json对象
        JsonObject obj = new JsonParser().parse(str).getAsJsonObject();
        String account = obj.get("account").toString();
        account=account.replace("\"","");
        String password = obj.get("password").toString();
        password=password.replace("\"","");
        String studentno = obj.get("studentno").toString();
        studentno=studentno.replace("\"","");

        UserEntity userEntity = new UserEntity();
        userEntity.setAccount(account);
        userEntity.setPassword(password);
        userEntity.setId(Pkutils.getUUID());
        userEntity.setStudentno(studentno);
        userEntity.setCreate_date(new Date());
        userMapper.addUser(userEntity);

    }

}
