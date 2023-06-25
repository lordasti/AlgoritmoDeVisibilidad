package es.mvera.algoritmo.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ProductTest {
	@Test
	public void deberiaIndicarQueElProductoTieneTallasEspecialesCuandoAlgunaDeLasTallasEsEspecial() throws Exception {
		Size tallaEspecial = Size.builder().special(true).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecial)).build();
		
		assertEquals(true, producto.tieneTallasEspeciales());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneTallasEspecialesCuandoNingunaDeLasTallasEsEspecial() throws Exception {
		Size tallaNoEspecial = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(tallaNoEspecial)).build();
		
		assertEquals(false, producto.tieneTallasEspeciales());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaQueVuelveProntoCuandoAlgunaDeLasTallasVuelvePronto() throws Exception {
		Size tallaVuelvePronto = Size.builder().backSoon(true).build();
		Product producto = Product.builder().sizes(List.of(tallaVuelvePronto)).build();
		
		assertEquals(true, producto.algunaTallaVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaQueVuelveProntoCuandoNingunaDeLasTallasVuelvePronto() throws Exception {
		Size tallaNoVuelvePronto = Size.builder().backSoon(false).build();
		Product producto = Product.builder().sizes(List.of(tallaNoVuelvePronto)).build();
		
		assertEquals(false, producto.algunaTallaVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaQueTieneStockCuandoAlgunaDeLasTallasTieneStock() throws Exception {
		Stock conStock = Stock.builder().quantity(3).build();				
		Size tallaConStock = Size.builder().stock(conStock).build();		
		Product producto = Product.builder().sizes(List.of(tallaConStock)).build();
		
		assertEquals(true, producto.algunaTallaTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaQueTieneStockCuandoNingunaDeLasTallasTieneStock() throws Exception {		
		Size tallaSinStock = Size.builder().build();
		Product producto = Product.builder().sizes(List.of(tallaSinStock)).build();
		
		assertEquals(false, producto.algunaTallaTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaNoEspecialQueVuelveProntoCuandoAlgunaDeLasTallasNoEspecialesVuelvePronto() throws Exception {
		Size tallaEspecialNoVuelvePronto = Size.builder().special(true).backSoon(false).build();
		Size tallaNoEspecialVuelvePronto = Size.builder().special(false).backSoon(true).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialNoVuelvePronto,tallaNoEspecialVuelvePronto)).build();
		
		assertEquals(true, producto.algunaTallaNoEspecialVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaNoEspecialQueVuelveProntoCuandoNingunaDeLasTallasNoEspecialesVuelvePronto() throws Exception {
		Size tallaEspecialVuelvePronto = Size.builder().special(true).backSoon(true).build();
		Size tallaNoEspecialNoVuelvePronto = Size.builder().special(false).backSoon(false).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialVuelvePronto,tallaNoEspecialNoVuelvePronto)).build();
		
		assertEquals(false, producto.algunaTallaNoEspecialVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaNoEspecialQueTieneStockCuandoAlgunaDeLasTallasNoEspecialesTieneStock() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialSinStock = Size.builder().special(true).build();
		Size tallaNoEspecialConStock = Size.builder().special(false).stock(hayStock).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialSinStock,tallaNoEspecialConStock)).build();
		
		assertEquals(true, producto.algunaTallaNoEspecialTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaNoEspecialQueTieneStockCuandoNingunaDeLasTallasNoEspecialesTieneStock() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialConStock = Size.builder().special(true).stock(hayStock).build();
		Size tallaNoEspecialSinStock = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialConStock,tallaNoEspecialSinStock)).build();
		
		assertEquals(false, producto.algunaTallaNoEspecialTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaEspecialQueVuelveProntoCuandoAlgunaDeLasTallasEspecialesVuelvePronto() throws Exception {
		Size tallaEspecialVuelvePronto = Size.builder().special(true).backSoon(true).build();
		Size tallaNoEspecialVuelvePronto = Size.builder().special(false).backSoon(true).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialVuelvePronto,tallaNoEspecialVuelvePronto)).build();
		
		assertEquals(true, producto.algunaTallaEspecialVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaEspecialQueVuelveProntoCuandoNingunaDeLasTallasEspecialesVuelvePronto() throws Exception {
		Size tallaEspecialNoVuelvePronto = Size.builder().special(true).backSoon(false).build();
		Size tallaNoEspecialVuelvePronto = Size.builder().special(false).backSoon(true).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialNoVuelvePronto,tallaNoEspecialVuelvePronto)).build();
		
		assertEquals(false, producto.algunaTallaEspecialVuelvePronto());
	}
	
	@Test
	public void deberiaIndicarQueElProductoTieneAlgunaTallaEspecialQueTieneStockCuandoAlgunaDeLasTallasEspecialesTieneStock() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialConStock = Size.builder().special(true).stock(hayStock).build();
		Size tallaNoEspecialSinStock = Size.builder().special(false).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialConStock,tallaNoEspecialSinStock)).build();
		
		assertEquals(true, producto.algunaTallaEspecialTieneStock());
	}
	
	@Test
	public void deberiaIndicarQueElProductoNoTieneAlgunaTallaEspecialQueTieneStockCuandoNingunaDeLasTallasEspecialesTieneStock() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialSinStock = Size.builder().special(true).build();
		Size tallaNoEspecialConStock = Size.builder().special(false).stock(hayStock).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialSinStock,tallaNoEspecialConStock)).build();
		
		assertEquals(false, producto.algunaTallaEspecialTieneStock());
	}
}
