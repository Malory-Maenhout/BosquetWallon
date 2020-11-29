package be.malo.POJO;

import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Categorie {

	// Attributes/Variables
	
	private int id_categorie;
	private String type_categorie;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	private int id_configuration;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Categorie> categorieDAO = dao.getCategorieDAO();
	
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

	public int getId_configuration() {
		return id_configuration;
	}
	public void setId_configuration(int id_configuration) {
		this.id_configuration = id_configuration;
	}
	
	// Constructor
	
	public Categorie () {}
	
	public Categorie (int id_categorie, String type_categorie, double prix, int nbrPlaceDispo, int nbrPlaceMax, int id_configuration) 
	{
		this.id_categorie = id_categorie;
		this.type_categorie = type_categorie;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id_configuration = id_configuration;
	}
	
	public Categorie (String type_categorie, double prix, int nbrPlaceDispo, int nbrPlaceMax, int id_configuration) 
	{
		this.type_categorie = type_categorie;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
		this.id_configuration = id_configuration;
	}
	
	// Methodes
	
	// Methode that we will allows us to create all categorie of configuration
	public boolean create()
	{
		boolean cat = categorieDAO.create(this);
		return cat;
	}
	
	// Methode that we will allows us to find a categorie by id configuration
	public ArrayList<Categorie> findAll(int id)
	{
		ArrayList<Categorie> cat = categorieDAO.find(id);
		return cat;
	}
}