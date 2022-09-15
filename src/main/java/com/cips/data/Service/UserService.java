package com.cips.data.Service;

import java.util.Map;

public interface UserService {

    Map<String,Object> getUser(String username, String password);

}
