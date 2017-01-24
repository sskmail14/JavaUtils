/**
 * 
 */
package com.app.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ssenthi1
 *
 */
public class AboutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3879317282655574799L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		request.getRequestDispatcher("/views/jsp/about.jsp").forward(request, response);
	}

}
