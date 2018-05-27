package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.entity.MarkEntity;
import com.example.swpumapserv.entity.SearchhisEntity;
import com.example.swpumapserv.mapper.SearchMapper;
import com.example.swpumapserv.utils.Pkutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 11:17
 **/
@Service
public class SearchService extends BaseService {

    @Autowired
    SearchMapper searchMapper;
    public  void  addMark(SearchhisEntity searchhisEntity)
    {
        searchhisEntity.setId(Pkutils.getUUID());
        searchhisEntity.setCreate_date(new Date());
        searchMapper.addMark(searchhisEntity);
    }

    public List<SearchhisEntity> findall(String account)
    {
        return  searchMapper.findall(account);
    }
}
