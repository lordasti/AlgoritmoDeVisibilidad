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
			(!producto.tieneTallasEspeciales() && 
				(producto.algunaTallaVuelvePronto() || producto.algunaTallaTieneStock())
			) 
			|| 
			(producto.tieneTallasEspeciales() && 
				(
					(producto.algunaTallaEspecialVuelvePronto() && producto.algunaTallaNoEspecialVuelvePronto()) ||
					(producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock()) ||
					(!producto.algunaTallaEspecialTieneStock() && producto.algunaTallaNoEspecialTieneStock() && producto.algunaTallaEspecialVuelvePronto()) ||
					(producto.algunaTallaEspecialTieneStock() && !producto.algunaTallaNoEspecialTieneStock() && producto.algunaTallaNoEspecialVuelvePronto())
				)
			);				
	}
	
}
