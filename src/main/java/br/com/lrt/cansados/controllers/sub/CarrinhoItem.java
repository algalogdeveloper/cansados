package br.com.lrt.cansados.controllers.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.controllers.Invoke;
import br.com.lrt.cansados.model.UserRoles;

public class CarrinhoItem implements Invoke {

	@Override
	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles) {
		return "";
	}

}
