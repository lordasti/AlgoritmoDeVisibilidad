package es.mvera.algoritmo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SizeTest {
	@Test
	public void deberiaIndicarQueLaTallaNoTieneStockCuandoEsNulo() throws Exception {
		Size talla = Size.builder().build();
		
		assertEquals(false, talla.tieneStock());
	}
	
	@Test
	public void deberiaIndicarQueLaTallaNoTieneStockCuandoLaCantidadDelStockEs0() throws Exception {
		Stock stock = Stock.builder().quantity(0).build();
		Size talla = Size.builder().stock(stock).build();
		
		assertEquals(false, talla.tieneStock());
	}
	
	@Test
	public void deberiaIndicarQueLaTallaTieneStockCuandoLaCantidadDelStockEsMayorQue0() throws Exception {
		Stock stock = Stock.builder().quantity(1).build();
		Size talla = Size.builder().stock(stock).build();
		
		assertEquals(true, talla.tieneStock());
	}
}
