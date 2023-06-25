package es.mvera.algoritmo.errores;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControladorDeErrores {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public MensajeDeError controlarExcepcion(Exception e, WebRequest request) {		    
		return MensajeDeError.builder().codigoDeError(HttpStatus.INTERNAL_SERVER_ERROR.value()).fecha(LocalDateTime.now()).mensaje(e.getMessage()).build();
	}
}
