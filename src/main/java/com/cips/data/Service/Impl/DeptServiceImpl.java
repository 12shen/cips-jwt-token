package com.cips.data.Service.Impl;

import com.cips.data.Repository.DeptRepository;
import com.cips.data.Entity.Dept;
import com.cips.data.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> queryTreeSimpleData(){
        return deptRepository.findAllBylevel();
    }

}
