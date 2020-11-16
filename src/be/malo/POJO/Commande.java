package be.malo.POJO;

import java.util.HashSet;
import java.util.Set;

public class Commande {

	// Attributes/Variables
	
	private int id_cmd;
	private Client id_client;
	private String mode_paiement;
	private String mode_livraison;
	private double prix_total;
	private Set<Place> listPlace = new HashSet<>();
	
	// Getters and setters
	
	public int getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}
	
	public Client getId_client() {
		return id_client;
	}
	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}
	
	public String getMode_paiement() {
		return mode_paiement;
	}
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	
	public String getMode_livraison() {
		return mode_livraison;
	}
	public void setMode_livraison(String mode_livraison) {
		this.mode_livraison = mode_livraison;
	}
	
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	
	public Set<Place> getListPlace() 
	{
		return listPlace;
	}
	public void setListPlace(Set<Place> listPlace) 
	{
		this.listPlace = listPlace;
	}
	public void addPlace(Place place)
	{
		this.listPlace.add(place);
	}	
	public void removePlace(Place place)
	{
		this.listPlace.remove(place);
	}
	
	// Constructor
	
	public Commande () {}
	
	public Commande (int id_cmd, Client id_client, String mode_paiement, String mode_livraison, double prix_total) 
	{
		this.id_cmd = id_cmd;
		this.id_client = id_client;
		this.mode_paiement = mode_paiement;
		this.mode_livraison = mode_livraison;
		this.prix_total = prix_total;
	}
}