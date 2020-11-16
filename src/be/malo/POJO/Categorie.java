package be.malo.POJO;

public class Categorie {

	// Attributes/Variables
	
	private int id_categorie;
	private String type_categorie;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private Configuration id_configuration;
	
	// Getters and setters
	
	public int getId_categorie() {
		return id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
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

	public Configuration getId_configuration() {
		return id_configuration;
	}
	public void setId_configuration(Configuration id_configuration) {
		this.id_configuration = id_configuration;
	}
	
	// Constructor
	
	public Categorie () {}
	
	public Categorie (int id_categorie, String type_categorie, double prix, int nbrPlaceDispo, int nbrPlaceMax, Configuration id_configuration) 
	{
		this.id_categorie = id_categorie;
		this.type_categorie = type_categorie;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id_configuration = id_configuration;
	}
}