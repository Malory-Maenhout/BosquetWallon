package be.malo.POJO;

import java.util.HashSet;
import java.util.Set;

public class Artistes extends Personne{

	// Attributes/Variables
	
	private Set<Spectacle> listSpectacle = new HashSet<>();
	
	// Getters and setters
	
	public Set<Spectacle> getListSpectacle() 
	{
		return listSpectacle;
	}
	public void setListSpectacle(Set<Spectacle> listSpectacle) 
	{
		this.listSpectacle = listSpectacle;
	}
	public void addSpectacle(Spectacle spectacle)
	{
		this.listSpectacle.add(spectacle);
	}	
	public void removeSpectacle(Spectacle spectacle)
	{
		this.listSpectacle.remove(spectacle);
	}
	
	// Constructor
	
	public Artistes () {}
	
	public Artistes (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id_personne, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}