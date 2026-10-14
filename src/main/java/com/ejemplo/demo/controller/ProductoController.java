package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.service.ProductoService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;

    public ProductoController(ProductoService service){
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }
    
    @PostMapping 
    public Producto guardar(@RequestBody Producto producto){
        return service.guardar(producto);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> manejarArgumentoInvalido(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(Map.of(
                "status", 400,
                "error", "Bad Request",
                "mensaje", e.getMessage()
        ));
    }

}
