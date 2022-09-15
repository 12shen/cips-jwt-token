package com.cips.data.Service;

import com.cips.data.Entity.Cache;

import java.util.List;

public interface CacheService {
    Cache  cache(String id);
    List<Cache> list();
    void deleteCacheUser();
}
