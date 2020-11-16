package be.malo.POJO;

import java.util.Date;

public class PlanningSalle {
	
	// Attributes/Variables
	
	private int id_planningsalle;
	private Date date_debut;
	private Date date_fin;
	private Reservation id_reservation;
	private Gestionnaire id_gestionnaire;
	
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
	
	public Reservation getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(Reservation id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	public Gestionnaire getId_gestionnaire() {
		return id_gestionnaire;
	}
	public void setId_gestionnaire(Gestionnaire id_gestionnaire) {
		this.id_gestionnaire = id_gestionnaire;
	}
	
	// Constructor
	
	public PlanningSalle () {}
	
	public PlanningSalle (int id_planningsalle, Date date_debut, Date date_fin, Reservation id_reservation, Gestionnaire id_gestionnaire) 
	{
		this.id_planningsalle = id_planningsalle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_reservation = id_reservation;
		this.id_gestionnaire = id_gestionnaire;
	}
}