package com.example.demo.controller;

import com.example.demo.entity.Auto;
import com.example.demo.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
public class AutoController {

    private final AutoService autoService;

    @Autowired
    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    // Obtener todos los autos
    @GetMapping
    public ResponseEntity<List<Auto>> obtenerTodosLosAutos() {
        return new ResponseEntity<>(autoService.obtenerTodosLosAutos(), HttpStatus.OK);
    }

    // Obtener auto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Auto> obtenerAutoPorId(@PathVariable Long id) {
        Auto auto = autoService.obtenerAutoPorId(id);
        if (auto != null) {
            return new ResponseEntity<>(auto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear auto
    @PostMapping
    public ResponseEntity<Auto> crearAuto(@RequestBody Auto auto) {
        return new ResponseEntity<>(autoService.crearAuto(auto), HttpStatus.CREATED);
    }

    // Actualizar auto
    @PutMapping("/{id}")
    public ResponseEntity<Auto> actualizarAuto(@PathVariable Long id, @RequestBody Auto auto) {
        Auto autoActualizado = autoService.actualizarAuto(id, auto);
        if (autoActualizado != null) {
            return new ResponseEntity<>(autoActualizado, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar auto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuto(@PathVariable Long id) {
        autoService.eliminarAuto(id);
        return ResponseEntity.noContent().build();
    }
}
