package com.project.backend.repository;

import com.project.backend.entity.BillEntity;
import com.project.backend.entity.ServiceApplicationEntity;
import com.project.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

   @Query("SELECT c FROM BillEntity c WHERE c.user=?1")
   public  List<BillEntity> getAllProductByCategoryId(UserEntity id);
}
