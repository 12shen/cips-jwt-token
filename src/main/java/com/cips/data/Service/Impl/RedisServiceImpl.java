package com.cips.data.Service.Impl;

import com.cips.data.Common.Result;
import com.cips.data.Redis.RedisUtil;
import com.cips.data.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result getRedisData(){
        /*Map<String,Object> map = new HashMap<>();
        if (redisClient.exists("key_test")){
            map.put("1",redisClient.get("key_test"));
            System.out.println("从redis获取数据!!!");
        }else {
            map.put("1","1");
            redisClient.set("key_test",map);
            System.out.println("从数据库获取数据!!!");
        }
        return map;*/

        String code=null;
/**
 *
 * */

       // String code =  null;
        if(redisUtil.hasKey("ZZRCYJ")){
            long num = redisUtil.incr("ZZRCYJ",1);
            code = String.format("%06d", num);
            return Result.ok().data("code",code);
        }else {
            boolean flag = redisUtil.set("ZZRCYJ", 0);
            if(flag){
                long num = redisUtil.incr("ZZRCYJ", 1);
                code = String.format("%06d", num);
            }
            return Result.ok().data("code",code);

        }
    }

}
