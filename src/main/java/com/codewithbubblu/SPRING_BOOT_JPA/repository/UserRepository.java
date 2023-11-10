package com.codewithbubblu.SPRING_BOOT_JPA.repository;

import com.codewithbubblu.SPRING_BOOT_JPA.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> {

    @Query("from AppUser a where a.email=:email and a.password=:password")
    AppUser loginUser(@Param("email") String email, @Param("password") String password);
}
