package be.malo.POJO;

public class Place {

	// Attributes/Variables
	
	private int id_place;
	private int numplace;
	private double prix;
	private Representation id_representation;
	private Commande id_cmd;
	
	// Getters and setters
	
	public int getId_place() {
		return id_place;
	}
	public void setId_place(int id_place) {
		this.id_place = id_place;
	}
	
	public int getNumplace() {
		return numplace;
	}
	public void setNumplace(int numplace) {
		this.numplace = numplace;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Representation getId_representation() {
		return id_representation;
	}
	public void setId_representation(Representation id_representation) {
		this.id_representation = id_representation;
	}
	
	public Commande getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(Commande id_cmd) {
		this.id_cmd = id_cmd;
	}
	
	// Constructor
	
	public Place () {}
	
	public Place (int id_place, int numplace, double prix, Representation id_representation, Commande id_cmd) 
	{
		this.id_place = id_place;
		this.numplace = numplace;
		this.prix = prix;
		this.id_representation = id_representation;
		this.id_cmd = id_cmd;
	}
}