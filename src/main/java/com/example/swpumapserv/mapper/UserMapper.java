package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.utils.CyException;
import com.example.swpumapserv.utils.CyWebException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    @Insert("insert into user (id,account,password,studentno,create_date) values(#{id},#{account},#{password},#{studentno},#{create_date})")
    public  void  addUser(UserEntity userEntity) throws CyWebException;

    @Select("select * from user where account=#{account}")
    public  UserEntity findUser(@Param("account") String account);


    @Select("select * from user where studentno=#{studentno}")
    public  UserEntity findUserBystudentno(@Param("studentno") String studentno);

}
