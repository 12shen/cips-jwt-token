package com.cips.data.Service.Impl;

import com.cips.data.Repository.FilesRepository;
import com.cips.data.Entity.Files;
import com.cips.data.Service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilesServiceImpl implements FilesService {
    @Autowired
    private FilesRepository filesRepository;

    @Override
    public List<Files> getFiles() {
        return filesRepository.findAll();
    }


}
