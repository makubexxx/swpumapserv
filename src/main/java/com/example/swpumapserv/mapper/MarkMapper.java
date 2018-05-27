package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.LocationEntity;
import com.example.swpumapserv.entity.MarkEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MarkMapper {

    @Insert("insert into collectmark (id,account,latitude,longitude,location_desc,text_desc,create_date) values( #{id},#{account},#{latitude},#{longitude},#{location_desc},#{text_desc},#{create_date})")
    public  void  addMark(MarkEntity markEntity);


    @Select("select * from collectmark  where account=#{account} order by create_date desc")
    public List<MarkEntity> findall(@Param("account") String account);
}
