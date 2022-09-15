package com.cips.data.Service.Impl;

import com.cips.data.Repository.TaskRepository;
import com.cips.data.Entity.Task;
import com.cips.data.Quertz.QuertzManage;
import com.cips.data.Service.QuertzTaskService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuertzTaskServiceImpl implements QuertzTaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private QuertzManage quertzManage;
    @Override
    public List<Task> queryQuertzTask() {
        return taskRepository.findByJobStatus();
    }

    @Override
    public void pauseTaskById(String id) throws SchedulerException {
        Optional<Task> task = taskRepository.findById(id);
        quertzManage.pauseJob(task.get().getJobName(),task.get().getJobGroup());
    }


    /**
    public void  pauseTaskById(String id) throws SchedulerException{
        Optional<Task> task1=taskRepository.findById(id);
        quertzManage.pauseJob(task.get().getJonName,task.get().getJobGroup());
    }*/

    @Override
    public void resumeTaskById(String id) throws SchedulerException {
        Optional<Task> task = taskRepository.findById(id);
        quertzManage.resumeJob(task.get().getJobName(),task.get().getJobGroup());
    }
}
