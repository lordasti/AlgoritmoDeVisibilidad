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
public class Size {
	
	@Id
	private final Integer id;
	private final Integer productId;
	private final Boolean backSoon;
	private final Boolean special;
}
