package tp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tp.beans.Livre;
import tp.services.Catalogue;
import tp.util.Util;

/**
 * Servlet implementation class for Servlet: Modif
 *
 */
@WebServlet(urlPatterns="/Enregistrer")
 public class Enregistrer extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5025403143147044905L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Enregistrer() {
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
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println( this.getClass().getName() + " : " + request.getRequestURI() );
		
		Livre livre = null ;
		String erreur = null ;
		String sId = request.getParameter("id");

		System.out.println( "Id = " + sId );
		
		if ( sId != null )
		{
			int iId = -1 ;
			try {
				iId = Integer.parseInt(sId);
			} catch (NumberFormatException e) {
				iId = -1 ;
				erreur = "Identifiant de livre invalide : " + sId ;
			}
			
			if ( null == erreur ) // Pas d'erreur
			{
				Catalogue catalogue = Catalogue.getCatalogue() ;
				livre = catalogue.getById(iId);
				if ( livre != null )
				{
					erreur = modifierLivre ( request, livre );
				}
				else
				{
					erreur = "Livre inexistant : id = " + iId ;
				}
			}
		}
		else
		{
			erreur = "Pas d'identifiant de livre !" ;
			//Util.errorPage(request, response, "Parametre Id absent.");
		}
		
		if ( erreur != null )
		{
			Util.errorPage(request, response, erreur );
		}
		else
		{
			request.setAttribute("livre", livre);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Modif.jsp");
			rd.forward(request, response);
		}
	}
	
	/**
	 * Modification du livre ( affectation des paramètres du formulaire )
	 * @param request
	 * @param livre
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private String modifierLivre(HttpServletRequest request, Livre livre ) throws ServletException, IOException 
	{		
		String s = null ;
		
		s = request.getParameter("titre");
		if ( s != null )
		{
			livre.setTitre(s);
		}
		
		s = request.getParameter("auteur");
		if ( s != null )
		{
			livre.setAuteur(s);
		}
		
		s = request.getParameter("prix");
		if ( s != null )
		{
			try {
				double d = Double.parseDouble(s);
				livre.setPrix(d);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return "Parametre PRIX invalide : " + s ; // Erreur
			}
		}
		return null ; // Pas d'erreur
	}
}