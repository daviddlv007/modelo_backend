package com.example.demo.repository;

import com.example.demo.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerroRepository extends JpaRepository<Perro, Long> {
}
