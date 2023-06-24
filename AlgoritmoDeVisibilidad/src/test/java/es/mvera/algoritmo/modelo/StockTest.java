package es.mvera.algoritmo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StockTest {
	
	@Test
	public void deberiaIndicarQueNoHayStockCuandoLaCantidadEs0() throws Exception {
		Stock stock = Stock.builder().quantity(0).build();
		
		assertEquals(false, stock.hayStock());
	}
	
	@Test
	public void deberiaIndicarQueNoHayStockCuandoLaCantidadEsPositiva() throws Exception {
		Stock stock = Stock.builder().quantity(1).build();		
		
		assertEquals(true, stock.hayStock());
	}
}
