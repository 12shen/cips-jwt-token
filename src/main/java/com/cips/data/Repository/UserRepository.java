package com.cips.data.Repository;

import com.cips.data.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {

    User findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);

}

//public interface UserResposity extends JpaRepository<>