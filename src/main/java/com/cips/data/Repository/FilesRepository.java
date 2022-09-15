package com.cips.data.Repository;

import com.cips.data.Entity.Files;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files,String> {
}
