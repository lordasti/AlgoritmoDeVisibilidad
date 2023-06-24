package es.mvera.algoritmo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mvera.algoritmo.modelo.Product;

@Repository
public interface RepositorioProduct extends JpaRepository<Product, Integer> {

}
