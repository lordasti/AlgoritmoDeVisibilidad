package es.mvera.algoritmo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ProductoTest {
	@Test
	public void deberiaIndicarQueElProductoTieneTallasEspecialesCuandoAlgunaDeLasTallasEsEspecial() throws Exception {
		Size talla1 = Size.builder().special(false).build();
		Size talla2 = Size.builder().special(true).build();
		Size talla3 = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(true, producto.tieneTallasEspeciales());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneTallasEspecialesCuandoNingunaDeLasTallasEsEspecial() throws Exception {
		Size talla1 = Size.builder().special(false).build();
		Size talla2 = Size.builder().special(false).build();
		Size talla3 = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(false, producto.tieneTallasEspeciales());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaQueVuelveProntoCuandoAlgunaDeLasTallasVuelvePronto() throws Exception {
		Size talla1 = Size.builder().backSoon(false).build();
		Size talla2 = Size.builder().backSoon(true).build();
		Size talla3 = Size.builder().backSoon(false).build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(true, producto.algunaTallaVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaQueVuelveProntoCuandoNingunaDeLasTallasVuelvePronto() throws Exception {
		Size talla1 = Size.builder().special(false).build();
		Size talla2 = Size.builder().special(false).build();
		Size talla3 = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(false, producto.algunaTallaVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaQueTieneStockCuandoAlgunaDeLasTallasTieneStock() throws Exception {
		Stock conStock = Stock.builder().quantity(3).build();
		Stock sinStock = Stock.builder().quantity(0).build();
		Size talla1 = Size.builder().stock(sinStock).build();
		Size talla2 = Size.builder().stock(conStock).build();
		Size talla3 = Size.builder().build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(true, producto.algunaTallaTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaQueTieneStockCuandoNingunaDeLasTallasTieneStock() throws Exception {
		Stock sinStock = Stock.builder().quantity(0).build();
		Size talla1 = Size.builder().stock(sinStock).build();
		Size talla2 = Size.builder().stock(sinStock).build();
		Size talla3 = Size.builder().build();
		Product producto = Product.builder().sizes(List.of(talla1,talla2,talla3)).build();
		
		assertEquals(false, producto.algunaTallaTieneStock());
	}
}
