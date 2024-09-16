package br.com.lrt.cansados.model;

import java.time.LocalDate;

public class Associado {
	
	public long id;
	public String nome;
	public LocalDate dtMatricula;
	public String type;
	
	public Associado() {
		// TODO Auto-generated constructor stub
	}

	public Associado(long id, String nome, LocalDate dtMatricula, String type) {
		this.id = id;
		this.nome = nome;
		this.dtMatricula = dtMatricula;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDtMatricula() {
		return dtMatricula;
	}

	public void setDtMatricula(LocalDate dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Associado [id=" + id + ", nome=" + nome + ", dtMatricula=" + dtMatricula + ", type=" + type + "]";
	}
	
	

}
