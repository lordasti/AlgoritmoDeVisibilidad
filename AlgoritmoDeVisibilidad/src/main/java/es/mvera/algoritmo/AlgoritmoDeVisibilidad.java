package es.mvera.algoritmo;

import java.util.Comparator;
import java.util.List;

import es.mvera.algoritmo.modelo.Product;


public class AlgoritmoDeVisibilidad {
	
	public static List<Product> obtenerListaDeProductosVisibles(List<Product> productos) {
		return productos.stream().filter(AlgoritmoDeVisibilidad::esVisible).sorted(Comparator.comparing(Product::getSequence)).toList();
	}
	
	protected static boolean esVisible(Product producto) {				
		return 
			elProductoSinTallasEspecialesEsVisible(producto)|| elProductoConTallasEspecialesEsVisible(producto);				
	}

	private static boolean elProductoConTallasEspecialesEsVisible(Product producto) {
		return producto.tieneTallasEspeciales() && 
			(
				elProductoTieneTantoTallasEspecialesComoNoEspecialesQueVuelvenPronto(producto) ||
				elProductoTieneTantoTallasEspecialesComoNoEspecialesConStock(producto) ||
				elProductoNoTieneStockDeTallasEspecialesPeroAlgunaDeEllasVuelveProntoYSiHayStockDeTallasNoEspeciales(producto) ||
				elProductoNoTieneStockDeTallasNoEspecialesPeroAlgunaDeEllasVuelveProntoYSiHayStockDeTallasEspeciales(producto)
			);
	}

	private static boolean elProductoSinTallasEspecialesEsVisible(Product producto) {
		return !producto.tieneTallasEspeciales() && elProductoVuelveProntoOTieneStock(producto);
	}
	
	private static boolean elProductoNoTieneStockDeTallasNoEspecialesPeroAlgunaDeEllasVuelveProntoYSiHayStockDeTallasEspeciales(Product producto) {
		return producto.algunaTallaEspecialTieneStock() && !producto.algunaTallaNoEspecialTieneStock() && producto.algunaTallaNoEspecialVuelvePronto();
	}

	private static boolean elProductoNoTieneStockDeTallasEspecialesPeroAlgunaDeEllasVuelveProntoYSiHayStockDeTallasNoEspeciales(Product producto) {
		return !producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock() && producto.algunaTallaEspecialVuelvePronto();
	}

	private static boolean elProductoTieneTantoTallasEspecialesComoNoEspecialesConStock(Product producto) {
		return producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock();
	}

	private static boolean elProductoTieneTantoTallasEspecialesComoNoEspecialesQueVuelvenPronto(Product producto) {
		return producto.algunaTallaEspecialVuelvePronto() && producto.algunaTallaNoEspecialVuelvePronto();
	}
	
	

	private static boolean elProductoVuelveProntoOTieneStock(Product producto) {
		return producto.algunaTallaVuelvePronto() || producto.algunaTallaTieneStock();
	}
	
}
