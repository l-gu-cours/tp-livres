package tp.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {

	public final static void errorPage(HttpServletRequest request, HttpServletResponse response, String s) throws ServletException, IOException
	{
		request.setAttribute("msg", s);
//		RequestDispatcher rd = request.getRequestDispatcher("/Erreur.jsp");
//		rd.forward(request, response);
		forward(request, response, "/Erreur.jsp");
	}

	public final static void forwardToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		forward(request, response, "/Liste.jsp");
	}
	
	public final static void forwardToFiltre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		forward(request, response, "/Filtre.jsp");
	}
	
	public final static void forward(HttpServletRequest request, HttpServletResponse response, String jsp) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);		
	}
	
}
