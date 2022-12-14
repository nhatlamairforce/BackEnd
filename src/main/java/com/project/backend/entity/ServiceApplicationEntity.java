package com.project.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "service_application")
public class ServiceApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity car;

    @OneToOne
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private ApartmentEntity apartment;

    @Column(name = "day1")
    private String day1;

    @Column(name = "day2")
    private String day2;

    @Column(name = "type")
    private String type;
}
