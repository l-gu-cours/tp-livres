package tp.beans;

import java.io.Serializable;

public class Livre implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	private int  id = -1;
	
	private String titre = null;

	private String auteur = null;

	private double prix = 0.0;
	
	public Livre(int id, String titre, String auteur, double prix ) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
