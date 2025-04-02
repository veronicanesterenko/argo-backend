package com.website.argo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "producer")
    private List<Product> productList;
}
