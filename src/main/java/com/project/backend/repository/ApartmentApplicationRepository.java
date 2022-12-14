package com.project.backend.repository;

import com.project.backend.entity.ApartmentApplicationEntity;
import com.project.backend.entity.ApartmentEntity;
import com.project.backend.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentApplicationRepository extends JpaRepository<ApartmentApplicationEntity, Long> {
    @Query("SELECT c FROM ApartmentApplicationEntity c WHERE c.apartment=?1")
    public  List<ApartmentApplicationEntity> getAllControll(ApartmentEntity r);

    @Query("SELECT c FROM ApartmentApplicationEntity c WHERE c.user=?1")
    public  List<ApartmentApplicationEntity> getUserApp(UserEntity r);
}
