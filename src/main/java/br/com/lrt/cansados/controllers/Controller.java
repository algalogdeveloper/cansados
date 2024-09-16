package br.com.lrt.cansados.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.model.Funcionario;

@WebServlet(name = "Controller", urlPatterns = "/controller")

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Funcionario f = new Funcionario();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String entity = "br.com.lrt.cansados.controllers.sub." + request.getParameter("invoke");
			Class<?> instance = Class.forName(entity);
			Invoke invoke = (Invoke) instance.newInstance();
			String mvc = invoke.invoke(request, response, f.getRoles());
			System.out.println(mvc);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(mvc);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no controller post:" + e);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String entity = "br.com.lrt.cansados.controllers.sub." + request.getParameter("invoke");
			Class<?> instance = Class.forName(entity);
			Invoke invoke = (Invoke) instance.newInstance();
			String mvc = invoke.invoke(request, response, f.getRoles());
			RequestDispatcher dispatcher = request.getRequestDispatcher(mvc);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro no controller:" + e);
		}
	}

}
