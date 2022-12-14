package com.project.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "apartment")
public class ApartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tp")
    private String tp;
    @Column(name = "quan")
    private String quan;
    @Column(name = "phuong")
    private String phuong;
    @Column(name = "duong")
    private String duong;
    @Column(name = "quequan")
    private String quequan;
    @Column(name = "dientich")
    private Float dientich;
    @Column(name = "price")
    private Float price;

    @Column(name = "wifi")
    private Boolean wifi;
    @Column(name = "wc")
    private Boolean wc;
    @Column(name = "pet")
    private Boolean pet;
    @Column(name = "tudo")
    private Boolean tudo;
    @Column(name = "kitchen")
    private Boolean kitchen;
    @Column(name = "ac")
    private Boolean ac;
    @Column(name = "fridge")
    private Boolean fridge;
    @Column(name = "washing")
    private Boolean washing;

    @Column(name = "number")
    private Integer number;
    @Column(name = "max_number")
    private Integer max_number;

    @Column(name = "name_owner")
    private String name_owner;
    @Column(name = "phone")
    private String phone;
    @Column(name = "descript")
    private String descript;
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "owner", referencedColumnName = "id")
    private UserEntity owner;
}
