package es.mvera.algoritmo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.mvera.algoritmo.modelo.Product;
import es.mvera.algoritmo.modelo.Size;
import es.mvera.algoritmo.modelo.Stock;

public class AlgoritmoDeVisibilidadTest {

	@Test
	public void unProductoNoEsVisibleCuandoNoTieneTallasEspecialesNiNingunaTallaVuelveProntoNiNingunaTallaTieneStock() throws Exception {		
		Size talla = Size.builder().id(11).productId(1).backSoon(false).special(false).build();		
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(talla)).build();		
		
		assertEquals(false, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoNoTieneTallasEspecialesNiNingunaTallaVuelveProntoPeroAlgunaTallaTieneStock() throws Exception {
		Stock stock = Stock.builder().sizeId(11).quantity(3).build();
		Size talla = Size.builder().id(11).productId(1).backSoon(false).special(false).stock(stock).build();		
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(talla)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoNoTieneTallasEspecialesPeroAlgunaTallaVuelvePronto() throws Exception {		
		Size talla = Size.builder().id(11).productId(1).backSoon(true).special(false).build();		
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(talla)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoNoEsVisibleCuandoTieneTallasEspecialesYNoHayNingunaTallaNoEspecialQueVuelvaProntoNiTengaStock() throws Exception {
		Size tallaEspecial = Size.builder().id(11).productId(1).backSoon(false).special(true).build();		
		Size tallaNoEspecial = Size.builder().id(12).productId(1).backSoon(false).special(false).build();
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(tallaEspecial,tallaNoEspecial)).build();		
		
		assertEquals(false, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoNoEsVisibleCuandoTieneTallasEspecialesYNoHayNingunaTallaEspecialQueVuelvaProntoNiTengaStock() throws Exception {
		
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoTieneTallasEspecialesYHayStockTantoDeAlgunaTallaEspecialComoDeAlgunaTallaNoEspecial() throws Exception {
		
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoTieneTallasEspecialesYHayStockDeAlgunaTallaEspecialYNoHayStockDeNingunaTallaNoEspecialPeroAlgunaVuelvePronto() throws Exception {
		
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoTieneTallasEspecialesYNoHayStockDeNingunaTallaEspecialPeroAlgunaVuelveProntoYHayStockDeAlgunaTallaNoEspecial() throws Exception {
		
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoTieneTallasEspecialesYVuelvenProntoTantoAlgunaTallaEspecialComoAlgunaTallasNoEspecial() throws Exception {
		
	}
}
