package com.example.swpumapserv.myservice;

import com.example.swpumapserv.base.BaseService;
import com.example.swpumapserv.entity.MarkEntity;
import com.example.swpumapserv.mapper.MarkMapper;
import com.example.swpumapserv.utils.Pkutils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-27 07:34
 **/
@Service
public class MarkService extends BaseService {
    @Autowired
    MarkMapper markMapper;
    public  void  addMark(MarkEntity markEntity)
    {
        markEntity.setId(Pkutils.getUUID());
        markEntity.setLocation_desc(markEntity.getAccount()+"的收集点");
        markEntity.setCreate_date(new Date());
         markMapper.addMark(markEntity);
    }

    public List<MarkEntity> findall(String account)
    {
        return  markMapper.findall(account);
    }
}
