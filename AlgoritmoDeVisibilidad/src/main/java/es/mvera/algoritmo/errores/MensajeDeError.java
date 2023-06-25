package es.mvera.algoritmo.errores;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MensajeDeError {
	private int codigoDeError;
	private LocalDateTime fecha;
	private String mensaje;
}
