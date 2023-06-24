package es.mvera.algoritmo;

import org.springframework.stereotype.Component;

import es.mvera.algoritmo.modelo.Product;

@Component
public class AlgoritmoDeVisibilidad {
	
	public static boolean esVisible(Product producto) {
		if(!producto.tieneTallasEspeciales() && !producto.algunaTallaVuelvePronto() && !producto.algunaTallaTieneStock()) {
			return false;
		}
		return true;
	}
	
}
