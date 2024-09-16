package br.com.lrt.cansados.controllers;

import br.com.lrt.cansados.model.Associado;
import br.com.lrt.cansados.repository.FuncionarioRepository;

public class Testa {

	public static void main(String[] args) {
		FuncionarioRepository fr = new FuncionarioRepository();
                System.out.println(fr.all(new Associado()));
		
	}

}
