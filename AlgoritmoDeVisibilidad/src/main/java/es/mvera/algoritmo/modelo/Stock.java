package es.mvera.algoritmo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Builder
public class Stock {
	
	@Id
	private final Integer sizeId;
	private final Integer quantity;
	
	public boolean hayStock() {
		return quantity > 0;
	}
}
