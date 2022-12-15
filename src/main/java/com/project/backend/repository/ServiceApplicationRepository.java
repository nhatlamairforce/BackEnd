package com.project.backend.repository;

import com.project.backend.entity.ServiceApplicationEntity;
import com.project.backend.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceApplicationRepository extends JpaRepository<ServiceApplicationEntity, Integer> {
    @Query("SELECT r FROM ServiceApplicationEntity r WHERE r.user=?1")
    public List<ServiceApplicationEntity> getAllRole(UserEntity r );
}
