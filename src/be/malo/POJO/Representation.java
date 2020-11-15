package be.malo.POJO;

import java.util.Date;

public class Representation {

	// Attributes/Variables
	
	private int id_representation;
	private Date date_debut;
	private Date date_fin;
	private Date heure_porte_open;
	
	// Getters and setters
	
	public int getId_representation() {
		return id_representation;
	}
	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
	}
	
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	public Date getHeure_porte_open() {
		return heure_porte_open;
	}
	public void setHeure_porte_open(Date heure_porte_open) {
		this.heure_porte_open = heure_porte_open;
	}
	
	// Constructor
	
	public Representation () {}
	
	public Representation (int id_representation, Date date_debut, Date date_fin, Date heure_porte_open) 
	{
		this.id_representation = id_representation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_porte_open = heure_porte_open;
	}
}