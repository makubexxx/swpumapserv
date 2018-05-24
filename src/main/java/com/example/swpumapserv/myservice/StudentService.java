package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.entity.StudentEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.mapper.StudentMapper;
import com.example.swpumapserv.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-23 15:05
 **/
@Service
public class StudentService extends BaseService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    UserMapper  userMapper;
    public  void  addStudent(String account)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentno(account);
        studentEntity.setIs_bind(0);
        studentMapper.addStudent(studentEntity);


    }

    public List<StudentEntity> findall()
    {
        List<StudentEntity> list= studentMapper.findall();
         for (StudentEntity studentEntity:list)
         {
             if (studentEntity.getIs_bind()==0)
             {
                  studentEntity.setIs_bindstr("未绑定");
                 studentEntity.setAccount("空");
             }
             else {
                 studentEntity.setIs_bindstr("已绑定");
               UserEntity userEntity= userMapper.findUserBystudentno(studentEntity.getStudentno());
               studentEntity.setAccount(userEntity.getAccount());
             }
         }
        return  list;
    }
    public StudentEntity findByNo(String studentno)
    {
        return studentMapper.findByNo(studentno);
    }
}
