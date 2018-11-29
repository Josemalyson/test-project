package com.java.test.project.testproject.erro.execao;

public class ProjectTesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8597716510293782110L;

	public ProjectTesException(String message) {
		super(message);
	}

	public ProjectTesException(String message, String cause) {
		super(message, new Throwable(cause));
	}

}
