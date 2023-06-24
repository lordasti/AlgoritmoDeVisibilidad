package es.mvera.algoritmo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import es.mvera.algoritmo.modelo.Product;
import es.mvera.algoritmo.modelo.Size;

public class AlgoritmoDeVisibilidadTest {

	@Test
	public void unProductoNoEsVisibleCuandoNoTieneTallasEspecialesNiNingunaTallaVuelveProntoNiNingunaTallaTieneStock() throws Exception {		
		Size talla = Size.builder().id(11).productId(1).backSoon(false).special(false).build();		
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(talla)).build();		
		
		assertEquals(false, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoNoTieneTallasEspecialesNiNingunaTallaVuelveProntoPeroAlgunaTallaTieneStock() throws Exception {
		
	}
	
	@Test
	public void deberiaDevolverUnProductoCuandoNoTieneTallasEspecialesPeroAlgunaTallaVuelvePronto() throws Exception {
		
	}
	
	@Test
	public void unProductoNoEsVisibleCuandoTieneTallasEspecialesYNoHayNingunaTallaNoEspecialQueVuelvaProntoNiTengaStock() throws Exception {
		
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
