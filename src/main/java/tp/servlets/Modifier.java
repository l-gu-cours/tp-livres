package tp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Livre;
import tp.services.Catalogue;

/**
 * Servlet implementation class for Servlet: Modif
 *
 */
@WebServlet(urlPatterns="/Modifier")
 public class Modifier extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5025403143147044905L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Modifier() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process( request,  response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process( request,  response);
	}   	  	    
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livre livre = null ;
		Catalogue cat = Catalogue.getCatalogue() ;
		String sId = request.getParameter("id");
		if ( sId != null )
		{
			int iId = Integer.parseInt(sId);
			livre = cat.getById(iId);
			request.setAttribute("livre", livre);
			RequestDispatcher rd = request.getRequestDispatcher("/Modif.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/Erreur.jsp");
			rd.forward(request, response);
		}
	}
}