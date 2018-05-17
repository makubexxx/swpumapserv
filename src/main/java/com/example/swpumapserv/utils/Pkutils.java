package com.example.swpumapserv.utils;

import java.util.UUID;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 13:47
 **/
public class Pkutils {

    public static String getUUID(){
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
