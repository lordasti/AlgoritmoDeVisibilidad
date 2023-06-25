package es.mvera.algoritmo.modelo;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Size {
	
	@Id
	@Column(name="ID")
	private  Integer id;
	
	@Column(name="PRODUCTID")
	private  Integer productId;
	
	@Column(name="BACKSOON")
	private  boolean backSoon;
	
	@Column(name="SPECIAL")
	private  boolean special;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "ID")
	private  Stock stock;
	
	public boolean tieneStock() {
		return Optional.ofNullable(stock).map(Stock::hayStock).orElse(false);
	}
}
