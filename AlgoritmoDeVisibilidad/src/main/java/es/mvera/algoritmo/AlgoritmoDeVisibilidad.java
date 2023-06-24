package es.mvera.algoritmo;

import es.mvera.algoritmo.modelo.Product;


public class AlgoritmoDeVisibilidad {
	
	public static boolean esVisible(Product producto) {
		if(!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && !producto.algunaTallaTieneStock()) {
			return false;
		}		
		return (!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && producto.algunaTallaTieneStock());
	}
	
}
