package es.mvera.algoritmo.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.mvera.algoritmo.modelo.Size;

@DataJpaTest
public class RepositorioSizeTest {
	
	@Autowired
    private RepositorioSize repositorioSize;
 
    @Test
    public void deberiaDevolverElNumeroDeProductosDelRepositorio() {
        assertEquals(17, repositorioSize.count());        
    }
    
    @Test
    public void deberiaRecuperarCorrectamenteElObjetoDeLaBD() {
    	Size size = repositorioSize.findById(11).orElseThrow();
    	        
        assertEquals(11, size.getId());
        assertEquals(1, size.getProductId());
        assertEquals(true, size.isBackSoon());
        assertEquals(false, size.isSpecial());
        assertEquals(11, size.getStock().getSizeId());
        assertEquals(0, size.getStock().getQuantity());
    }
}
