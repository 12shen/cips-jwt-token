package com.cips.data.Service.Impl;

import com.cips.data.Repository.CacheRepository;
import com.cips.data.Entity.Cache;
import com.cips.data.Service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    private CacheRepository cacheRepository;

    @Override
    //@Cacheable(cacheNames = "cache",key = "#id")
    @Cacheable(value = {"cache"},key = "#id")
    public Cache cache(String id) {
        System.out.println("从数据中查询数据！");
        Cache cache = new Cache(id,"zxg","2594523286@qq.com");
        return cache;
    }



    @Override
    @Cacheable(value = "user")
    public List<Cache> list() {
        System.out.println("MySQL已查询到！");
        return cacheRepository.findAll();
    }

    @Override
    @CacheEvict(value = "user")
    public void deleteCacheUser() {
    }
}
