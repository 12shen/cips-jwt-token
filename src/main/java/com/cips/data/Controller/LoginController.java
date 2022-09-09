package com.cips.data.Controller;

import com.cips.data.Common.Result;
import com.cips.data.Entity.User;
import com.cips.data.Service.UserService;
import com.cips.data.Annotation.PassToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String login()
    {
        return "login";
    }

    @PassToken
    @RequestMapping(path = "/login")
    @ResponseBody
    public Result findUser(@RequestBody User user) {
        Map<String,Object> map = userService.getUser(user.getUsername(),user.getPassword());
        return Result.ok().data(map);
    }

}
