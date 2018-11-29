package com.java.test.project.testproject.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.java.test.project.testproject.erro.DetalhesErro;

@RestControllerAdvice
public class TestProjectExceptionHandler {

	@ExceptionHandler(Exception.class)
	public DetalhesErro handleException(Exception ex, WebRequest request) {
		return new DetalhesErro(Arrays.asList(ex.getMessage()), null, HttpStatus.BAD_REQUEST.value());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public DetalhesErro handleProjectTesException(MethodArgumentNotValidException ex, WebRequest request) {

		DetalhesErro detalhesErro = new DetalhesErro(new ArrayList<>(), null, HttpStatus.BAD_REQUEST.value());

		ex.getBindingResult().getAllErrors().forEach(erros -> {
			StringBuilder messages = new StringBuilder();
			messages.append(ex.getBindingResult().getFieldError().getField()).append(": ")
					.append(erros.getDefaultMessage());
			detalhesErro.getMensagemErro().add(messages.toString());
		});

		return detalhesErro;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public DetalhesErro handleConstraintViolationException(ConstraintViolationException constraintViolationException,
			WebRequest request) {
		Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
		StringBuilder messages = new StringBuilder();
		constraintViolations.stream()
				.map(constraintViolation -> messages.append(constraintViolation.getMessage() + "\n"))
				.collect(Collectors.toList());

		return new DetalhesErro(Arrays.asList(constraintViolationException.getMessage()),
				constraintViolationException.getCause().getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
	}
}
