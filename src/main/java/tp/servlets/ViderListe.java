package tp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: Filtre
 *
 */
@WebServlet(urlPatterns="/ViderListe")
 public class ViderListe extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ViderListe() {
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
		System.out.println("Vider");
		HttpSession session = request.getSession();
		session.removeAttribute("liste");		

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
	}  	
}