package com.cips.data.Repository;

import com.cips.data.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,String> {
    @Query(value = "SELECT * FROM sys_task WHERE job_status = '1'",nativeQuery = true)
    List<Task> findByJobStatus();

    @Query(value = "SELECT * FROM sys_task WHERE id =  :id",nativeQuery = true)
    Optional<Task> findById(@Param("id") String id);
    //Optional<Task> findTasksBy
}
