package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.StudentEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-23 15:06
 **/
@Mapper
@Component
public interface StudentMapper {

    @Insert("insert into student (studentno,is_bind) values (#{studentno},#{is_bind});")
    public void  addStudent(StudentEntity studentEntity);

    @Select("select * from student")
    public List<StudentEntity> findall();

    @Select("select * from student where studentno=#{studentno}")
    public StudentEntity findByNo(@Param("studentno")String studentno);

    @Update("update student set is_bind=1 where studentno=#{studentno}")
    public  void updateStudent(StudentEntity studentEntity);
}
