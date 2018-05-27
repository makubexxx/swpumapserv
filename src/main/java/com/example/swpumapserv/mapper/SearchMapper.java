package com.example.swpumapserv.mapper;

import com.example.swpumapserv.entity.MarkEntity;
import com.example.swpumapserv.entity.SearchhisEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 11:10
 **/
@Mapper
@Component
public interface SearchMapper {


    @Insert("insert into searchhis (id,account,search_cotent,create_date) values( #{id},#{account},#{search_cotent},#{create_date})")
    public  void  addMark(SearchhisEntity searchhisEntity);


    @Select("select * from searchhis  where account=#{account} order by create_date desc")
    public List<SearchhisEntity> findall(@Param("account") String account);
}
