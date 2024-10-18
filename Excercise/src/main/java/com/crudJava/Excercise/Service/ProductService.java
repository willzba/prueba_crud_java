package com.crudJava.Excercise.Service;

import com.crudJava.Excercise.Entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private List<ProductEntity> products;

    public ProductService() {
        products = new ArrayList<ProductEntity>();
        products.add(new ProductEntity(UUID.randomUUID(),"Laptop","Electrónica", 1000.00, 50));
        products.add(new ProductEntity(UUID.randomUUID(),"Silla","Electrónica", 1000.00, 50));
        products.add(new ProductEntity(UUID.randomUUID(),"Cámara","Fotografía", 5000.00, 15));

    }

    public List<ProductEntity> obtenerTodos() {
        return products;
    }

    public Optional<ProductEntity> obtenerPorId(UUID id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public ProductEntity agregarProducto(ProductEntity producto) {
        // Verificar si el ID es null y generar un UUID si es necesario
        if (producto.getId() == null) {
            producto.setId(UUID.randomUUID());  // Generar un nuevo UUID si el id es null
        }
        products.add(producto);
        return producto;
    }

    public ProductEntity actualizarProducto(UUID id, ProductEntity productoActualizado) {
        Optional<ProductEntity> productoExistente = obtenerPorId(id);
        if (productoExistente.isPresent()) {
            ProductEntity producto = productoExistente.get();
            producto.setName(productoActualizado.getName());
            producto.setCategory(productoActualizado.getCategory());
            producto.setPrice(productoActualizado.getPrice());
            producto.setStock(productoActualizado.getStock());
            return producto;
        }
        return null;  // Si no existe el producto, devolver null o manejar el error
    }

    public boolean eliminarProducto(UUID id) {
        return products.removeIf(p -> p.getId().equals(id));
    }
}
