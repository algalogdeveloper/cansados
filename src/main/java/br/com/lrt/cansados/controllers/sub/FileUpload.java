package br.com.lrt.cansados.controllers.sub;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet(name = "FileUpload",urlPatterns = "/file.upload")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, 
			maxFileSize = 1024 * 1024 * 10, 
			maxRequestSize = 1024 * 1024 * 100)
public class FileUpload extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Part filePart = request.getPart("file");
			String fileName = filePart.getSubmittedFileName();
			for (Part part : request.getParts()) {
				part.write(request.getServletContext().getRealPath("/upload/")+fileName);
			}
			response.getWriter().print("sucessofull");
		} catch (IOException | ServletException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
}
