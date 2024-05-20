package com.barmont.market.persistence;

import com.barmont.market.persistence.crud.ProductoCrudRepository;
import com.barmont.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Clase encargada de interactuar con la tabla de productos de nuestra base de datos

// INDICA QUE ESTA CLASE INTERACTUA CON LA DB
@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategroria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
