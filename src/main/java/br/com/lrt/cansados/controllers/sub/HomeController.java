package br.com.lrt.cansados.controllers.sub;

import br.com.lrt.cansados.controllers.Invoke;
import br.com.lrt.cansados.model.UserRoles;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class HomeController implements Invoke {

	@Override
	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles) {
		
		HashMap<Object, Object> model = new HashMap<Object, Object>();
		model.put("message", "Test servlet + jstl");
		request.setAttribute("model", model);
		return "WEB-INF/jsp/associados/home.jsp";
	}

}
