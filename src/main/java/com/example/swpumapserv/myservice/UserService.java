package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.controller.UserController;
import com.example.swpumapserv.entity.StudentEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.mapper.StudentMapper;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;
    public  int  addUser(  String studentno, String account ,String passsword ) throws CyWebException
    {
        //根据studentno;
        StudentEntity studentEntity = studentMapper.findByNo(studentno);
        if (studentEntity!=null&&studentEntity.getIs_bind()!=1) {
            UserEntity userEntity = new UserEntity();
            userEntity.setAccount(account);
            userEntity.setPassword(passsword);
            userEntity.setId(Pkutils.getUUID());
            userEntity.setStudentno(studentno);
            userEntity.setCreate_date(new Date());
            userMapper.addUser(userEntity);
            studentMapper.updateStudent(studentEntity   );
            return  0;
        }
        return 1;

    }

    public  int  login(String account ,String password) throws CyWebException
    {
         int result;
         //通过username 取 entity
        UserEntity  userEntity =userMapper.findUser(account);
        //通过账号查找不到id  说明用户不存在
       if(userEntity==null)
        {
            result= 1;
        }
        else
       {
           if (userEntity.getPassword().equals(password))
           {

               session = request.getSession();
               session.setAttribute("user",userEntity);
               result=  0;
           }
           else {
               result=  1;
           }
       }
        return  result;

    }


}
