package es.mvera.algoritmo.repositorio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RepositorioSizeTest {
	@Autowired
    private RepositorioSize repositorioSize;
 
    @Test
    void deberiaDevolverElNumeroDeProductosDelRepositorio() {
        assertEquals(17, repositorioSize.count());        
    }
}
