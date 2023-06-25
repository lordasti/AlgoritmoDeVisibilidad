package es.mvera.algoritmo;

import java.util.Comparator;
import java.util.List;

import es.mvera.algoritmo.modelo.Product;


public class AlgoritmoDeVisibilidad {
	
	public static List<Product> obtenerListaDeProductosVisibles(List<Product> productos) {
		return productos.stream().filter(AlgoritmoDeVisibilidad::esVisible).sorted(Comparator.comparing(Product::getSequence)).toList();
	}
	
	protected static boolean esVisible(Product producto) {
		if((!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && !producto.algunaTallaTieneStock())
			|| (producto.tieneTallasEspeciales() && !producto.algunaTallaNoEspecialVuelvePronto() && !producto.algunaTallaNoEspecialTieneStock())
			|| (producto.tieneTallasEspeciales() && !producto.algunaTallaEspecialVuelvePronto() && !producto.algunaTallaEspecialTieneStock())) {
			return false;
		}		
		return (!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && producto.algunaTallaTieneStock()) 
			|| (!producto.tieneTallasEspeciales() && producto.algunaTallaVuelvePronto())
			|| (producto.tieneTallasEspeciales() && producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock())
			|| (producto.tieneTallasEspeciales() && producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialVuelvePronto())
			|| (producto.tieneTallasEspeciales() && producto.algunaTallaEspecialVuelvePronto() && producto.algunaTallaNoEspecialTieneStock())
			|| (producto.tieneTallasEspeciales() && producto.algunaTallaEspecialVuelvePronto() && producto.algunaTallaNoEspecialVuelvePronto());
	}
	
}
