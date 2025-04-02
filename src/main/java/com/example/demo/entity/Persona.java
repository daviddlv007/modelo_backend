package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;
}