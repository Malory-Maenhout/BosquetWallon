package be.malo.POJO;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Place {

	// Attributes/Variables
	
	private int id_place;
	private int numplace;
	private int id_representation;
	private double prix;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Place> placeDAO = dao.getPlaceDAO();
	
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
	
	public int getId_representation() {
		return id_representation;
	}
	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
		
	// Constructor
	
	public Place () {}
	
	public Place (int id_place, int numplace, int id_representation, double prix) 
	{
		this.id_place = id_place;
		this.numplace = numplace;
		this.id_representation = id_representation;
		this.prix = prix;
	}
	
	public Place (int numplace, int id_representation, double prix) 
	{
		this.numplace = numplace;
		this.id_representation = id_representation;
		this.prix = prix;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a place
	public boolean create() 
	{
		boolean place = placeDAO.create(this);
		return place;
	}
	
	// Methode that we will allows us to find a place
	public Place find()
	{
		Place pl = placeDAO.find(this);
		return pl;
	}
}