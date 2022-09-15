package com.cips.data.Repository;

import com.cips.data.Entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept,String> {

    @Query(value = "select *  FROM dept where level in ('0','1')",nativeQuery = true)
    List<Dept> findAllBylevel();

}
