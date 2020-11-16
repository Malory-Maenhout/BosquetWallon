package be.malo.POJO;

import java.util.HashSet;
import java.util.Set;

public class Gestionnaire extends Personne{

	// Attributes/Variables
	
	private Set<PlanningSalle> listPlanningSalle = new HashSet<>();
	
	// Getters and setters
	
	public Set<PlanningSalle> getListPlanningSalle() 
	{
		return listPlanningSalle;
	}
	public void setListPlanningSalle(Set<PlanningSalle> listPlanningSalle) 
	{
		this.listPlanningSalle = listPlanningSalle;
	}
	public void addPlanningSalle(PlanningSalle planningSalle)
	{
		this.listPlanningSalle.add(planningSalle);
	}	
	public void removePlanningSalle(PlanningSalle planningSalle)
	{
		this.listPlanningSalle.remove(planningSalle);
	}
	
	// Constructor
	
	public Gestionnaire () {}

	public Gestionnaire (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id_personne, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}