package com.cips.data.Service.Impl;

import com.cips.data.Repository.UserRepository;
import com.cips.data.Common.CustomerDefinedException;
import com.cips.data.Common.JwtTokenUtil;
import com.cips.data.Common.ResultEnum;
import com.cips.data.Entity.User;
import com.cips.data.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String,Object> getUser(String username,String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        User userinfo = userRepository.findByUsernameAndPassword(username,password);
        if(userinfo != null){
            map.put("list",userinfo);
            //map.putAll();
            String token = JwtTokenUtil.createToken(userinfo.getUsername(), "123456");
            map.put("token",token);
            /***/
            map.put("token",token);

        }else {
            throw new CustomerDefinedException(ResultEnum.UNEXIST_ERROR);
        }
        return map;
    }

}
