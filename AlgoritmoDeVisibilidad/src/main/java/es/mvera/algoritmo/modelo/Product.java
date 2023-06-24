package es.mvera.algoritmo.modelo;

import static java.util.function.Predicate.not;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Builder
public class Product { 
	@Id
	private final Integer id; 
	private final Integer sequence;
	private final List<Size> sizes;
	
	public boolean tieneTallasEspeciales() {
		return sizes.stream().anyMatch(Size::isSpecial);
	}
	
	public boolean algunaTallaVuelvePronto() {
		return sizes.stream().anyMatch(Size::isBackSoon);
	}
	
	public boolean algunaTallaTieneStock() {
		return sizes.stream().anyMatch(Size::tieneStock);
	}

	public boolean algunaTallaNoEspecialVuelvePronto() {
		return sizes.stream().filter(not(Size::isSpecial)).anyMatch(Size::isBackSoon);
	}

	public boolean algunaTallaNoEspecialTieneStock() {
		return sizes.stream().filter(not(Size::isSpecial)).anyMatch(Size::tieneStock);
	}
}
