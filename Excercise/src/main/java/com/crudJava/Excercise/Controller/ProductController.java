package com.crudJava.Excercise.Controller;

import com.crudJava.Excercise.Entity.ProductEntity;
import com.crudJava.Excercise.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //obtener todos los productos
    @GetMapping
    public List<ProductEntity>obtenerTodos(){
        return productService.obtenerTodos();
    }

    // Obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> obtenerPorId(@PathVariable UUID id) {
        Optional<ProductEntity> producto = productService.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ProductEntity agregarProducto(@RequestBody ProductEntity producto) {
        return productService.agregarProducto(producto);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> actualizarProducto(@PathVariable UUID id, @RequestBody ProductEntity producto) {
        ProductEntity actualizado = productService.actualizarProducto(id, producto);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable UUID id) {
        boolean eliminado = productService.eliminarProducto(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
