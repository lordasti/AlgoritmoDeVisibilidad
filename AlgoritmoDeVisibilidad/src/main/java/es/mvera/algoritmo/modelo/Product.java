package es.mvera.algoritmo.modelo;

import static java.util.function.Predicate.not;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product { 
	@Id
	@Column(name="ID")
	private Integer id;

	@Column(name="SEQUENCE")
	private Integer sequence;
	
	@OneToMany
	@JoinColumn(name = "PRODUCTID")
	private List<Size> sizes;
	
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

	public boolean algunaTallaEspecialVuelvePronto() {
		return sizes.stream().filter(Size::isSpecial).anyMatch(Size::isBackSoon);
	}
	
	public boolean algunaTallaEspecialTieneStock() {
		return sizes.stream().filter(Size::isSpecial).anyMatch(Size::tieneStock);
	}

}
