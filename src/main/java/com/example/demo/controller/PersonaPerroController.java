package com.example.demo.controller;

import com.example.demo.entity.PersonaPerro;
import com.example.demo.service.PersonaPerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona-perro")
public class PersonaPerroController {

    private final PersonaPerroService personaPerroService;

    @Autowired
    public PersonaPerroController(PersonaPerroService personaPerroService) {
        this.personaPerroService = personaPerroService;
    }

    // Obtener todas las relaciones entre persona y perro
    @GetMapping
    public ResponseEntity<List<PersonaPerro>> obtenerTodasLasRelaciones() {
        List<PersonaPerro> relaciones = personaPerroService.obtenerTodasLasRelaciones();
        return new ResponseEntity<>(relaciones, HttpStatus.OK);
    }

    // Obtener relación por ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonaPerro> obtenerRelacionPorId(@PathVariable Long id) {
        PersonaPerro relacion = personaPerroService.obtenerRelacionPorId(id);
        if (relacion != null) {
            return new ResponseEntity<>(relacion, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear relación entre persona y perro
    @PostMapping
    public ResponseEntity<PersonaPerro> crearRelacion(@RequestBody PersonaPerro personaPerro) {
        PersonaPerro nuevaRelacion = personaPerroService.crearRelacion(personaPerro);
        return new ResponseEntity<>(nuevaRelacion, HttpStatus.CREATED);
    }

    // Actualizar relación entre persona y perro
    @PutMapping("/{id}")
    public ResponseEntity<PersonaPerro> actualizarRelacion(@PathVariable Long id, @RequestBody PersonaPerro personaPerro) {
        PersonaPerro relacionActualizada = personaPerroService.actualizarRelacion(id, personaPerro);
        if (relacionActualizada != null) {
            return new ResponseEntity<>(relacionActualizada, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar relación entre persona y perro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRelacion(@PathVariable Long id) {
        personaPerroService.eliminarRelacion(id);
        return ResponseEntity.noContent().build();
    }
}
