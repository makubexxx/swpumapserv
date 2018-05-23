package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.entity.StudentEntity;
import com.example.swpumapserv.mapper.StudentMapper;
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
    public  void  addStudent(String account)
    {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentno(account);
        studentEntity.setIs_bind(0);
        studentMapper.addStudent(studentEntity);


    }

    public List<StudentEntity> findall()
    {
        return studentMapper.findall();
    }
    public StudentEntity findByNo(String studentno)
    {
        return studentMapper.findByNo(studentno);
    }
}
