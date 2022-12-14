package com.project.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "bill")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "bienlai")
    private long bienlai;

    @Column(name = "content_one")
    private String content_one;

    @Column(name = "price_one")
    private long price_one;

    @Column(name = "service_one")
    private String service_one;

    @Column(name = "price_service")
    private long price_service;

    @Column(name = "date")
    private String date;

    @Column(name = "status")
    private Boolean status;
}
