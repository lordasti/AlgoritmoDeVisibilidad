package es.mvera.algoritmo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
	
	@Id
	@Column(name="SIZEID")
	private Integer sizeId;
	
	@Column(name="QUANTITY")
	private Integer quantity;	
	
	public boolean hayStock() {
		return quantity > 0;
	}
}
