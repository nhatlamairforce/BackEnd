package com.project.backend.repository;

import com.project.backend.entity.CarEntity;
import com.project.backend.entity.ServiceApplicationEntity;
import com.project.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query("SELECT c FROM CarEntity c WHERE c.id=?1")
    public CarEntity getUserFID(Long id);

    @Query("SELECT c FROM CarEntity c WHERE c.user=?1")
    public List<CarEntity> getAll(UserEntity id);
}
