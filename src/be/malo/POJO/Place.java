package be.malo.POJO;

public class Place {

	// Attributes/Variables
	
	private int id_place;
	private int numplace;
	private double prix;
	
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
	
	// Constructor
	
	public Place () {}
	
	public Place
	(int id_place, int numplace, double prix) 
	{
		this.id_place = id_place;
		this.numplace = numplace;
		this.prix = prix;
	}	
}