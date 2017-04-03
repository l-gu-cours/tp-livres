package tp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tp.beans.Livre;
import tp.services.Catalogue;
import tp.util.Util;

/**
 * Servlet implementation class for Servlet: Filtre
 *
 */
@WebServlet(urlPatterns="/Filtrer")
 public class Filtrer extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Filtrer() {
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
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		System.out.println("p1 = '" + p1 + "'");
		System.out.println("p2 = '" + p2 + "'");
		
		if ( null == p1 && null == p2 )
		{
			HttpSession session = request.getSession();
			session.removeAttribute("mini" );
			session.removeAttribute("maxi" );
			session.removeAttribute("liste" );
			Util.forwardToFiltre(request, response);
		}
		else
		{
			filtrer(request, response);
		}
	}
	
	private void filtrer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String p1 = request.getParameter("p1");
		String p2 = request.getParameter("p2");
		
		if ( p1 == null ) 
		{
			p1 = "0";
		}
		else if ( p1.trim().length() == 0 )
		{
			p1 = "0";
		}

		if ( p2 == null ) 
		{
			p2 = "999999";
		}
		else if ( p2.trim().length() == 0 )
		{
			p2 = "999999";
		}
			
		try {
			System.out.println("parseDouble : ");
			System.out.println(" . p1 = '" + p1 + "'");
			System.out.println(" . p2 = '" + p2 + "'");
			double d1 = Double.parseDouble(p1);
			double d2 = Double.parseDouble(p2);
			
			Catalogue cat = Catalogue.getCatalogue() ;
			List<Livre> v = cat.select(d1, d2);

			//--- Stockage en session
			HttpSession session = request.getSession();
			session.setAttribute("mini", new Double(d1) );
			session.setAttribute("maxi", new Double(d2) );
			session.setAttribute("liste", v);
			
			Util.forwardToList(request, response);

//			RequestDispatcher rd = request.getRequestDispatcher("/Liste.jsp");
//			rd.forward(request, response);
			
		} catch (NumberFormatException e) {
			Util.errorPage(request, response, "NumberFormatException");
		}
	}
}