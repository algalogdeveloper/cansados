package br.com.lrt.cansados.controllers;

import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.model.UserRoles;

import javax.servlet.http.HttpServletRequest;

public interface Invoke {

	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles);
}
