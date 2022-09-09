package com.cips.data.Controller;

import com.cips.data.Annotation.UserLoginToken;
import com.cips.data.Common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class IndexController {

    private String prefix = "index/";

    @GetMapping("/index")

    //@GeneratorType("/index");//对应的类型
    public String index()
    {
        return prefix + "index";
    }

    @UserLoginToken
    @PostMapping("/test")
    @ResponseBody
    public Result test(){
        return Result.ok().message("你已通过验证啦!");
    }
}
