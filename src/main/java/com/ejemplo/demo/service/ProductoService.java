package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Producto;
import com.ejemplo.demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repository;
    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }
    public List<Producto> listar() {
		 return repository.findAll();
	 }
	 public Producto guardar(Producto producto) {
        if (producto.getPrecio()==null || producto.getPrecio() <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
		 return repository.save(producto);
	 }
}
