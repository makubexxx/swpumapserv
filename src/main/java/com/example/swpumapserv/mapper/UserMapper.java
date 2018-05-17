package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.utils.CyException;
import com.example.swpumapserv.utils.CyWebException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    @Insert("insert into user (id,account,password,studentno,create_date) values(#{id},#{account},#{password},#{studentno},#{create_date})")
    public  void  addUser(UserEntity userEntity) throws CyWebException;


}
