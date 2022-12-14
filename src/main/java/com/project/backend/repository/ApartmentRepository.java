package com.project.backend.repository;

import com.project.backend.entity.ApartmentEntity;
import com.project.backend.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
    @Query("SELECT c FROM ApartmentEntity c")
    public  List<ApartmentEntity> getAll();

    @Query("SELECT c FROM ApartmentEntity c WHERE c.owner=?1")
    public  List<ApartmentEntity> getAllControll(UserEntity r);

    @Query("SELECT c FROM ApartmentEntity c WHERE c.id=?1")
    public  ApartmentEntity getOne(Long id);


}
