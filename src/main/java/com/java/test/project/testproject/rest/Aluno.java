package com.java.test.project.testproject.rest;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Aluno {
	@NotNull
	@NotBlank(message="campo obrigatorio {0}")
	@NotEmpty
	private String nome;
	@NotNull
	private Long idade;

	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(String nome, Long idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

}