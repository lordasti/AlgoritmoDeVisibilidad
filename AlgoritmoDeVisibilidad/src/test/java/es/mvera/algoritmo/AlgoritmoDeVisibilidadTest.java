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
		Stock hayStock = Stock.builder().sizeId(11).quantity(3).build();
		Size tallaEspecial = Size.builder().id(11).productId(1).backSoon(false).special(true).stock(hayStock).build();		
		Size tallaNoEspecial = Size.builder().id(12).productId(1).backSoon(false).special(false).build();
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(tallaEspecial,tallaNoEspecial)).build();		
		
		assertEquals(false, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoNoEsVisibleCuandoTieneTallasEspecialesYNoHayNingunaTallaEspecialQueVuelvaProntoNiTengaStock() throws Exception {
		Size tallaEspecial = Size.builder().id(11).productId(1).backSoon(false).special(true).build();				
		Product producto = Product.builder().id(1).sequence(1).sizes(List.of(tallaEspecial)).build();		
		
		assertEquals(false, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoTieneTallasEspecialesYHayStockTantoDeAlgunaTallaEspecialComoDeAlgunaTallaNoEspecial() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialConStock = Size.builder().backSoon(false).special(true).stock(hayStock).build();		
		Size tallaNoEspecialConStock = Size.builder().backSoon(false).special(false).stock(hayStock).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialConStock,tallaNoEspecialConStock)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoTieneTallasEspecialesYHayStockDeAlgunaTallaEspecialYNoHayStockDeNingunaTallaNoEspecialPeroAlgunaVuelvePronto() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialConStock = Size.builder().backSoon(false).special(true).stock(hayStock).build();		
		Size tallaNoEspecialVuelveProntoSinStock = Size.builder().backSoon(true).special(false).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialConStock,tallaNoEspecialVuelveProntoSinStock)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoTieneTallasEspecialesYNoHayStockDeNingunaTallaEspecialPeroAlgunaVuelveProntoYHayStockDeAlgunaTallaNoEspecial() throws Exception {
		Stock hayStock = Stock.builder().quantity(3).build();
		Size tallaEspecialVuelveProntoSinStock = Size.builder().backSoon(true).special(true).build();		
		Size tallaNoEspecialNoVuelveProntoConStock = Size.builder().backSoon(false).special(false).stock(hayStock).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialVuelveProntoSinStock,tallaNoEspecialNoVuelveProntoConStock)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
	
	@Test
	public void unProductoEsVisibleCuandoTieneTallasEspecialesYVuelvenProntoTantoAlgunaTallaEspecialComoAlgunaTallasNoEspecial() throws Exception {		
		Size tallaEspecialVuelvePronto = Size.builder().backSoon(true).special(true).build();		
		Size tallaNoEspecialVuelvePronto = Size.builder().backSoon(true).special(false).build();
		Product producto = Product.builder().sizes(List.of(tallaEspecialVuelvePronto,tallaNoEspecialVuelvePronto)).build();		
		
		assertEquals(true, AlgoritmoDeVisibilidad.esVisible(producto));
	}
}
