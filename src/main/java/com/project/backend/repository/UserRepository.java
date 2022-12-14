package com.project.backend.repository;

import com.project.backend.entity.ServiceApplicationEntity;
import com.project.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

   @Query("SELECT c FROM UserEntity c WHERE c.phone=?1")
   public  UserEntity getUser(String phone);

   @Query("SELECT c FROM UserEntity c WHERE c.id=?1")
   public UserEntity getUserFID(Long id);
}
