package tp.services;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import tp.beans.Livre;

/**
 * Catalogue de livres ( en mémoire sous forme de "singleton" ) <br>
 * 
 * Récupération de l'instance unique du catalogue de livres : <br>
 *   Catalogue catalogue = Catalogue.getCatalogue() ; <br>
 * 
 * Récupération de tous les livres du catalogue ( filtre sans condition ) : <br>
 *   Vector<Livre> liste = catalogue.filtre();
 *   
 * Filtrage des livres avec prix mini et prix maxi ( mini et maxi peuvent être inversés ) : <br>
 *   Vector<Livre> liste = catalogue.filtre(mini, maxi);
 *   
 * Récupération d'un livre à partir de son identifiant : <br>
 *   Livre livre = catalogue.getLivre(id);
 *   
 *
 */
public class Catalogue 
{

	//--- SINGLETON  
	private static Catalogue catalogue = null ; 
	
	public final static Catalogue getCatalogue()
	{
		if ( catalogue != null )
		{
			return catalogue ;
		}
		else
		{
			catalogue = new Catalogue();
			return catalogue ;
		}
	}
	
	//------------------------------------------------------------------------------------------
	
	//--- Attribut(s) de la classe
	private Vector<Livre> liste_livres = new Vector<Livre>() ;

	private Catalogue() {
		int id = 0 ;
		liste_livres.add(new Livre(id++, "Germinal", "Zola", 12.00));
		liste_livres.add(new Livre(id++, "Le rouge et le noir", "Stendhal", 23.00));
		liste_livres.add(new Livre(id++, "Madame Bovary", "Flaubert", 17.50));
		liste_livres.add(new Livre(id++, "Le petit prince", "St Exupery", 29.30));
		liste_livres.add(new Livre(id++, "La peste", "Camus", 22.30));
		liste_livres.add(new Livre(id++, "Dune", "Herbert", 14.50));		
		liste_livres.add(new Livre(id++, "La bête humaine", "Zola", 32.70));		
	}

	
	/**
	 * Renvoie tous les livres du catalogue
	 * @return
	 */
	public Vector<Livre> getAll()
	{
		Vector<Livre> list = new Vector<Livre>() ;
		for ( Livre livre : liste_livres ) {
			list.add(livre) ;
		}
		return list;
	}
	
	/**
	 * Renvoie tous les livres dont le prix est compris entre p1 et p2
	 * @param p1
	 * @param p2
	 * @return
	 */
	public List<Livre> select(double p1, double p2)
	{
		double mini = p1 ;
		double maxi = p2 ;
		if ( p1 > p2 )
		{
			mini = p2 ;
			maxi = p1 ;			
		}
		Vector<Livre> selection = new Vector<Livre>() ;
		Iterator<Livre> iter = liste_livres.iterator();
		while ( iter.hasNext() )
		{
			Livre livre = (Livre) iter.next();
			double prix = livre.getPrix() ;
			if ( prix >= mini && prix <= maxi )
			{
				selection.add(livre);
			}
		}
		return selection;
	}
	
	/**
	 * Retourne le livre dont l'identifiant correspond au paramètre "id"
	 * ou NULL s'il n'y a aucun livre ayant cet identifiant.
	 * @param id
	 * @return
	 */
	public Livre getById(int id)
	{
		Iterator<Livre> iter = liste_livres.iterator();
		while ( iter.hasNext() )
		{
			Livre livre = (Livre) iter.next();
			if ( livre.getId() == id )
			{
				return livre ;
			}
		}
		return null ; // non trouvé !
	}

}
