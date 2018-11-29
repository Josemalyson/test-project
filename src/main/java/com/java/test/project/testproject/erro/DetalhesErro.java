package com.java.test.project.testproject.erro;

import java.util.ArrayList;
import java.util.List;

public class DetalhesErro {

	private List<String> mensagemErro = new ArrayList<>();;
	private String mensagemDetalhe;
	private int codigoErro;

	public DetalhesErro() {
		super();
	}

	public DetalhesErro(List<String> mensagemErro, String mensagemDetalhe, int codigoErro) {
		super();
		this.mensagemErro = mensagemErro;
		this.mensagemDetalhe = mensagemDetalhe;
		this.codigoErro = codigoErro;
	}

	public List<String> getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(List<String> mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

	public int getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}

	public String getMensagemDetalhe() {
		return mensagemDetalhe;
	}

	public void setMensagemDetalhe(String mensagemDetalhe) {
		this.mensagemDetalhe = mensagemDetalhe;
	}

}
