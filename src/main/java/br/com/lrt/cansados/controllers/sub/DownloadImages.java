package br.com.lrt.cansados.controllers.sub;

import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lrt.cansados.controllers.Invoke;
import br.com.lrt.cansados.model.UserRoles;

public class DownloadImages implements Invoke {

	@SuppressWarnings("deprecation")
	@Override
	public String invoke(HttpServletRequest request, HttpServletResponse response, UserRoles roles) {
		try {
			String img = request.getRealPath("/")+"upload/file.jpeg";
			System.out.println(img);
			FileInputStream stream = new FileInputStream(img);
			int in;
	        PrintWriter out = response.getWriter();
	        while((in=stream.read())!=-1) {
	          out.write(in);         
	       		
			}
	        stream.close();
	        return "/";
          
		} catch (Exception e) {
			throw new IllegalArgumentException(e.getCause());
		}
		
	}

}
