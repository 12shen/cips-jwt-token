package com.cips.data.Controller;

import com.cips.data.Common.Result;
import com.cips.data.Entity.Dept;
import com.cips.data.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class ZtreeController {

    private String prefix = "home/";

    @Autowired
    private DeptService deptService;

    @GetMapping("/ztree")
    public String ztree()
    {
        return prefix + "ztree";
    }

    @RequestMapping("/tree")
    @ResponseBody
    public Result getTreeData(){
        System.out.println("加载完毕!");
        List<Dept> depyList = deptService.queryTreeSimpleData();
        return Result.ok().data("list",depyList);

    }

}
