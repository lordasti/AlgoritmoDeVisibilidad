package es.mvera.algoritmo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.mvera.algoritmo.AlgoritmoDeVisibilidad;
import es.mvera.algoritmo.modelo.Product;
import es.mvera.algoritmo.repositorio.RepositorioProduct;

@RestController
@RequestMapping("/api")
public class ControladorProduct {
	
	@Autowired
	private RepositorioProduct repositorioProduct;
	
	@GetMapping("/productos/disponibles")
	public ResponseEntity<List<Product>> obtenerProductosDisponibles() {
		List<Product> productosVisibles = AlgoritmoDeVisibilidad.obtenerListaDeProductosVisibles(repositorioProduct.findAll());
	
		if (productosVisibles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(productosVisibles, HttpStatus.OK);
	}
	
	@RequestMapping(value = "*", method= {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.HEAD,RequestMethod.OPTIONS,RequestMethod.PATCH,RequestMethod.POST,RequestMethod.PUT,RequestMethod.TRACE})
	public ResponseEntity<String> noDisponible(){
		return new ResponseEntity<>("No disponible", HttpStatus.NOT_FOUND);
	}
}
