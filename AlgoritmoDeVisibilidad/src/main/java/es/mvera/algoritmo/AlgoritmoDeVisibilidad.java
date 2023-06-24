package es.mvera.algoritmo;

import es.mvera.algoritmo.modelo.Product;


public class AlgoritmoDeVisibilidad {
	
	public static boolean esVisible(Product producto) {
		if((!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && !producto.algunaTallaTieneStock())
			|| (producto.tieneTallasEspeciales() && !producto.algunaTallaNoEspecialVuelvePronto() && !producto.algunaTallaNoEspecialTieneStock())
			|| (producto.tieneTallasEspeciales() && !producto.algunaTallaEspecialVuelvePronto() && !producto.algunaTallaEspecialTieneStock())) {
			return false;
		}		
		return (!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && producto.algunaTallaTieneStock()) 
			|| (!producto.tieneTallasEspeciales() && producto.algunaTallaVuelvePronto())
			|| (producto.tieneTallasEspeciales() && producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock());
	}
	
}
