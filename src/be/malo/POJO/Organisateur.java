package be.malo.POJO;

import java.util.HashSet;
import java.util.Set;

public class Organisateur extends Personne{

	// Attributes/Variables
	
	private Set<Reservation> listReservation = new HashSet<>();
	
	// Getters and setters
	
	public Set<Reservation> getListReservation() 
	{
		return listReservation;
	}
	public void setListReservation(Set<Reservation> listReservation) 
	{
		this.listReservation = listReservation;
	}
	public void addReservation(Reservation reservation)
	{
		this.listReservation.add(reservation);
	}	
	public void removeReservation(Reservation reservation)
	{
		this.listReservation.remove(reservation);
	}
	
	// Constructor

	public Organisateur () {}
	
	public Organisateur (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id_personne, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}