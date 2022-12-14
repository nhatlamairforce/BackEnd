package com.project.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private Integer type;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "quequen")
    private String quequen;

    @Column(name = "cmnd")
    private String cmnd;

    @OneToOne
    @JoinColumn(name = "currentapart", referencedColumnName = "id")
    private ApartmentEntity apartment;
}
