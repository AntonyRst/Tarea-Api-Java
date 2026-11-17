package com.tarea.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EjerciciosController {

    @GetMapping("/api/perfil/{nombre}/{ciudad}/{curso}")
    public Map<String, String> obtenerPerfil(@PathVariable String nombre, @PathVariable String ciudad, @PathVariable String curso) {
        return Map.of("mensaje", "Nombre: " + nombre + " Ciudad: " + ciudad + " Curso: " + curso);
    }
}
