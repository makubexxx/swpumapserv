package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.UserEntity;
import com.example.swpumapserv.utils.CyWebException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-17 18:39
 **/
@Mapper
@Component
public interface LocationMapper {

    @Insert("insert into location (id,account,studentno,latitude,longitude,location_desc,collect_date) values( #{id},#{account},#{studentno},#{latitude},#{longitude},#{location_desc},#{collect_date})")
    public  void  addLocation(LocationEntity locationEntity);


    @Select("select * from location where account =#{account}")
    public List<LocationEntity> findByaccount(@Param("account") String account);
}
