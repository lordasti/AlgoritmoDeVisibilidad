package es.mvera.algoritmo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mvera.algoritmo.modelo.Stock; 

@Repository
public interface RepositorioStock extends JpaRepository<Stock, Integer> {

}
