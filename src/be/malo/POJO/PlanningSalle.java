package be.malo.POJO;

import java.util.Date;

public class PlanningSalle {
	
	// Attributes/Variables
	
	private int id_planningsalle;
	private Date date_debut;
	private Date date_fin;
	
	// Getters and setters
	
	public int getId_planningsalle() {
		return id_planningsalle;
	}
	public void setId_planningsalle(int id_planningsalle) {
		this.id_planningsalle = id_planningsalle;
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
	
	// Constructor
	
	public PlanningSalle () {}
	
	public PlanningSalle (int id_planningsalle, Date date_debut, Date date_fin) 
	{
		this.id_planningsalle = id_planningsalle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
}