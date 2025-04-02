package com.example.demo.controller;

import com.example.demo.entity.Perro;
import com.example.demo.service.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perros")
public class PerroController {

    private final PerroService perroService;

    @Autowired
    public PerroController(PerroService perroService) {
        this.perroService = perroService;
    }

    // Obtener todos los perros
    @GetMapping
    public ResponseEntity<List<Perro>> obtenerTodosLosPerros() {
        return new ResponseEntity<>(perroService.obtenerTodosLosPerros(), HttpStatus.OK);
    }

    // Obtener perro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Perro> obtenerPerroPorId(@PathVariable Long id) {
        Perro perro = perroService.obtenerPerroPorId(id);
        if (perro != null) {
            return new ResponseEntity<>(perro, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear perro
    @PostMapping
    public ResponseEntity<Perro> crearPerro(@RequestBody Perro perro) {
        return new ResponseEntity<>(perroService.crearPerro(perro), HttpStatus.CREATED);
    }

    // Actualizar perro
    @PutMapping("/{id}")
    public ResponseEntity<Perro> actualizarPerro(@PathVariable Long id, @RequestBody Perro perro) {
        Perro perroActualizado = perroService.actualizarPerro(id, perro);
        if (perroActualizado != null) {
            return new ResponseEntity<>(perroActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar perro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPerro(@PathVariable Long id) {
        perroService.eliminarPerro(id);
        return ResponseEntity.noContent().build();
    }
}
