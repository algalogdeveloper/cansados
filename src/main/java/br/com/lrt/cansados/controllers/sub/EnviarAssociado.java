package br.com.lrt.cansados.controllers.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.controllers.Invoke;
import br.com.lrt.cansados.model.UserRoles;

public class EnviarAssociado implements Invoke {

	@Override
	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles) {
		String nome = request.getParameter("nome");
		String dtmatricula = request.getParameter("dtmatricula");
		String type = request.getParameter("type");
		System.out.println(nome);
		System.out.println(dtmatricula);
		System.out.println(type);

		return "successfull";
	}

}
