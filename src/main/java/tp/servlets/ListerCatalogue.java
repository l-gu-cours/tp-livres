package tp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Livre;
import tp.services.Catalogue;
import tp.util.Util;

/**
 * Servlet implementation class for Servlet: Filtre
 *
 */
@WebServlet(urlPatterns="/ListerCatalogue" )
 public class ListerCatalogue extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ListerCatalogue() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		process( request,  response);
	}   	  	    
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Catalogue cat = Catalogue.getCatalogue() ;
		List<Livre> liste = cat.getAll();
		
		request.setAttribute("liste", liste);
		
		Util.forwardToList(request, response);
	}
}