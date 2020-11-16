package be.malo.POJO;

public class Reservation {

	// Attributes/Variables
	
	private int id_reservation;
	private double acompte;
	private double solde;
	private double prix_total;
	private String statut;
	private Organisateur id_organisateur;
	
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
	
	public Organisateur getId_organisateur() {
		return id_organisateur;
	}
	public void setId_organisateur(Organisateur id_organisateur) {
		this.id_organisateur = id_organisateur;
	}
	
	// Constructor

	public Reservation () {}
	
	public Reservation (int id_reservation, double acompte, double solde, double prix_total, String statut, Organisateur id_organisateur) 
	{
		this.id_reservation = id_reservation;
		this.acompte = acompte;
		this.solde = solde;
		this.prix_total = prix_total;
		this.statut = statut;
		this.id_organisateur = id_organisateur;
	}
}