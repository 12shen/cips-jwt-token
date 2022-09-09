package com.cips.data.Controller;

import com.cips.data.Annotation.AccessLimit;
import com.cips.data.Common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class FangshuaController {

    @AccessLimit(seconds=120, maxCount=5)
    @PostMapping("/fangshua")
    @ResponseBody
    public Result fangshua(){
        return Result.ok().message("已通过验证!");
    }

}
