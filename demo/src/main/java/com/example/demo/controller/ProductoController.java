package com.example.demo.controller;

import com.example.demo.dto.ProductoDto;
import com.example.demo.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertAndListProducts(@RequestBody ProductoDto productoDto) {
        return ResponseEntity.ok(productoService.insertAndListProducts(productoDto.getIdProducto(), productoDto.getNombre(), productoDto.getFecRegistro()));
    }
}
