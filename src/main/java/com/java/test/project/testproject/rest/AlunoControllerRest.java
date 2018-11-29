package com.java.test.project.testproject.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alunos")
public class AlunoControllerRest {

	@GetMapping()
	public Aluno teste(@Valid @NotEmpty @RequestParam(name = "nome") String nome) {
		return new Aluno(nome, 19L);
	}

	@PostMapping
	public Aluno teste2(@Valid @RequestBody Aluno aluno) {
		return aluno;
	}

}
