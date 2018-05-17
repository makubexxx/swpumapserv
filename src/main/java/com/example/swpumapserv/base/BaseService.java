package com.example.swpumapserv.base;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: Xuesheng
 * @create: 2018-05-15 13:55
 **/
@Service
public class BaseService {

    public static final String STATUS_SUCCESS = "0";
    public static final String STATUS_FAILED = "1";

    private final ConcurrentHashMap<String, Object> parallelLockMap = new ConcurrentHashMap<>();

    /**
     * 对象锁
     *
     * @param className
     * @return
     */
    protected Object getOrderLock(String className) {
        Object lock = this;
        if (parallelLockMap != null) {
            Object newLock = new Object();
            lock = parallelLockMap.putIfAbsent(className, newLock);
            if (lock == null) {
                lock = newLock;
            }
        }
        return lock;
    }

    /**
     * 移除对象锁
     *
     * @param key
     */
    protected void removeLock(String key) {
        parallelLockMap.remove(key);
    }
}
