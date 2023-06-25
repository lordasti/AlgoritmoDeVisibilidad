package es.mvera.algoritmo.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.mvera.algoritmo.modelo.Stock;

@DataJpaTest
public class RepositorioStockTest {
	@Autowired
    private RepositorioStock repositorioStock;
 
    @Test
    void deberiaDevolverElNumeroDeStockDelRepositorio() {
        assertEquals(15, repositorioStock.count());        
    }
    
    @Test
    public void deberiaRecuperarCorrectamenteElObjetoDeLaBD() {    	
    	Stock stock = repositorioStock.findById(11).orElseThrow();
    	        
        assertEquals(11, stock.getSizeId());
        assertEquals(0, stock.getQuantity());
    }
}
