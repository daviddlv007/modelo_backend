package com.example.demo.service;

import com.example.demo.entity.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // Obtener todas las personas
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    // Obtener persona por ID
    public Persona obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).orElse(null); // Devuelve null si no se encuentra
    }

    // Crear persona
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Actualizar persona
    public Persona actualizarPersona(Long id, Persona persona) {
        Persona personaExistente = obtenerPersonaPorId(id);
        if (personaExistente != null) {
            persona.setId(personaExistente.getId());
            return personaRepository.save(persona);
        }
        return null; // Retorna null si no se encuentra la persona
    }

    // Eliminar persona
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
