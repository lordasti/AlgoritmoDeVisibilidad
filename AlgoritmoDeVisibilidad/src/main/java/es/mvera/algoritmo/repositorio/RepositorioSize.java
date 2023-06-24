package es.mvera.algoritmo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.mvera.algoritmo.modelo.Size; 

@Repository
public interface RepositorioSize extends JpaRepository<Size, Integer> {

}
