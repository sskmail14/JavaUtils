/**
 * 
 */
package com.app.mvc.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ssenthi1
 *
 */
public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.getRequestDispatcher(getNextPage(request.getParameter("pump"))).forward(request, response);
	}
	
	/*To Be written in service side*/
	private String getNextPage(String path){
		if(Objects.nonNull(path) && !path.isEmpty() && !path.endsWith("home")){
			String[] splitPath = path.split("/");
			return 	"/"+splitPath[splitPath.length-1];
		}
		return "/views/jsp/home.jsp";
	}

}
