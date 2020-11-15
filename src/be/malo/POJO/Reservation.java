package be.malo.POJO;

public class Reservation {

	// Attributes/Variables
	
	private int id_reservation;
	private double acompte;
	private double solde;
	private double prix_total;
	private String statut;
	
	// Getters and setters
	
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	public double getAcompte() {
		return acompte;
	}
	public void setAcompte(double acompte) {
		this.acompte = acompte;
	}
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	
	public String getStatut() {
		return statut;
	}	
	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	// Constructor

	public Reservation () {}
	
	public Reservation (int id_reservation, double acompte, double solde, double prix_total, String statut) 
	{
		this.id_reservation = id_reservation;
		this.acompte = acompte;
		this.solde = solde;
		this.prix_total = prix_total;
		this.statut = statut;
	}
}