package be.malo.POJO;

public class Categorie {

	// Attributes/Variables
	
	private int id_caategorie;
	private String type_categorie;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	// Getters and setters
	
	public int getId_caategorie() {
		return id_caategorie;
	}
	public void setId_caategorie(int id_caategorie) {
		this.id_caategorie = id_caategorie;
	}
	
	public String getType_categorie() {
		return type_categorie;
	}
	public void setType_categorie(String type_categorie) {
		this.type_categorie = type_categorie;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public int getNbrPlaceDispo() {
		return nbrPlaceDispo;
	}
	public void setNbrPlaceDispo(int nbrPlaceDispo) {
		this.nbrPlaceDispo = nbrPlaceDispo;
	}
	
	public int getNbrPlaceMax() {
		return nbrPlaceMax;
	}
	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	
	// Constructor
	
	public Categorie () {}
	
	public Categorie (int id_caategorie, String type_categorie, double prix, int nbrPlaceDispo, int nbrPlaceMax) 
	{
		this.id_caategorie = id_caategorie;
		this.type_categorie = type_categorie;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}
}