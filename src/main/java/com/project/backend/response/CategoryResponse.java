package com.project.backend.response;

import com.project.backend.entity.ServiceApplicationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CategoryResponse {
    long id;
    String name;
    List<ServiceApplicationEntity> subCategory;
}
