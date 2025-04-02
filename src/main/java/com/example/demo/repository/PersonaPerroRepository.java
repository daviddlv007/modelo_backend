package com.example.demo.repository;

import com.example.demo.entity.PersonaPerro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaPerroRepository extends JpaRepository<PersonaPerro, Long> {
}
