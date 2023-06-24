package es.mvera.algoritmo.modelo;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
@Builder
public class Size {
	
	@Id
	private final Integer id;
	private final Integer productId;
	private final boolean backSoon;
	private final boolean special;
	private final Stock stock;
	
	public boolean tieneStock() {
		return Optional.ofNullable(stock).map(Stock::hayStock).orElse(false);
	}
}
