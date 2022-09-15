package com.cips.data.Repository;

import com.cips.data.Entity.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CacheRepository extends JpaRepository<Cache,String> {
    Optional<Cache> findById(@Param("id") String id);
}
