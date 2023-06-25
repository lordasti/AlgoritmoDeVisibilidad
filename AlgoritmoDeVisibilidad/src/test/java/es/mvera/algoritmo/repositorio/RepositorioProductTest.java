package es.mvera.algoritmo.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.mvera.algoritmo.modelo.Product;

@DataJpaTest
public class RepositorioProductTest {
	@Autowired
    private RepositorioProduct repositorioProduct;
 
    @Test
    void deberiaDevolverElNumeroDeProductosDelRepositorio() {
        assertEquals(5, repositorioProduct.count());        
    }
    
    @Test
    public void deberiaRecuperarCorrectamenteElObjetoDeLaBD() {
    	Product producto = repositorioProduct.findById(1).orElseThrow();
    	        
        assertEquals(1, producto.getId());
        assertEquals(10, producto.getSequence());
        assertEquals(3, producto.getSizes().size());
        assertEquals(11,producto.getSizes().get(0).getId());
        assertEquals(1, producto.getSizes().get(0).getProductId());
        assertEquals(true, producto.getSizes().get(0).isBackSoon());
        assertEquals(false, producto.getSizes().get(0).isSpecial());
        assertEquals(11, producto.getSizes().get(0).getStock().getSizeId());
        assertEquals(0, producto.getSizes().get(0).getStock().getQuantity());
    }
}
