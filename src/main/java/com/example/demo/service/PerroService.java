package com.example.demo.service;

import com.example.demo.entity.Perro;
import com.example.demo.repository.PerroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerroService {

    private final PerroRepository perroRepository;

    @Autowired
    public PerroService(PerroRepository perroRepository) {
        this.perroRepository = perroRepository;
    }

    // Obtener todos los perros
    public List<Perro> obtenerTodosLosPerros() {
        return perroRepository.findAll();
    }

    // Obtener perro por ID
    public Perro obtenerPerroPorId(Long id) {
        return perroRepository.findById(id).orElse(null);
    }

    // Crear perro
    public Perro crearPerro(Perro perro) {
        return perroRepository.save(perro);
    }

    // Actualizar perro
    public Perro actualizarPerro(Long id, Perro perro) {
        Perro perroExistente = obtenerPerroPorId(id);
        if (perroExistente != null) {
            perro.setId(perroExistente.getId());
            return perroRepository.save(perro);
        }
        return null; // Retorna null si no se encuentra el perro
    }

    // Eliminar perro
    public void eliminarPerro(Long id) {
        perroRepository.deleteById(id);
    }
}
