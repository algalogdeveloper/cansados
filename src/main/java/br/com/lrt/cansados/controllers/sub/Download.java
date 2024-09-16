package br.com.lrt.cansados.controllers.sub;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.controllers.Invoke;
import br.com.lrt.cansados.model.UserRoles;
import br.com.lrt.cansados.repository.AssociadoRepository;

public class Download implements Invoke {

	@Override
	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles) {
		AssociadoRepository ar = new AssociadoRepository();
		HashMap<Object, Object> model = new HashMap<Object, Object>();
		model.put("associados", ar.lista());
		request.setAttribute("model", model);
		return "/WEB-INF/jsp/associados/download.jsp";
	}

}
