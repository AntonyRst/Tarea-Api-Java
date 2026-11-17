package com.tarea.api;

import jdk.jfr.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EjerciciosController {

    @GetMapping("/api/perfil/{nombre}/{ciudad}/{curso}")
    public Map<String, String> obtenerPerfil(@PathVariable String nombre, @PathVariable String ciudad, @PathVariable String curso) {
        return Map.of("mensaje", "Nombre: " + nombre + " Ciudad: " + ciudad + " Curso: " + curso);
    }

    @GetMapping("/api/sumar")
    public Map<String, Integer> sumarNumero(@RequestParam int a, @RequestParam int b) {
        int suma = a + b;
        return Map.of("resultado: ", suma);
    }

    @GetMapping("/api/temperatura/{celsius}")
    public Map<String, Double> convertirTemperatura(@PathVariable double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        return Map.of(
                "celcius", celsius,
                "fahrenheit", fahrenheit
        );
    }

    @GetMapping("/api/tabla/{numero}")
    public List<String> generarTabla(@PathVariable int numero) {
        List<String> tabla = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            tabla.add(numero + " x " + i + " = " + (numero * i));
        }
        return tabla;
    }

    @GetMapping("/api/edad/{edad}")
    public Map<String, String> esMayor(@PathVariable int edad) {
        if (edad >= 18) {
            return Map.of("mensaje", "Edad: " + edad + ". Es mayor de edad");
        } else {
            return Map.of("mensaje", "Edad: " + edad + ". Es menor de edad");
        }
    }

    @GetMapping("/api/categorias")
    public List<Categoria> obtenerCategorias() {
        return List.of(
            new Categoria(1, "Laptops"),
            new Categoria(2, "Smartphones"),
            new Categoria(3, "Accesorios")
        );
    }
}

record Categoria(int id, String nombre) {}
