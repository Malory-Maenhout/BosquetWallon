package be.malo.POJO;

import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Spectacle {

	// Attributes/Variables
	
	private int id_spectacle;
	private String titre;
	private int nbrPlaceParClient;
	private int id_planningSalle;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Spectacle> spectacleDAO = dao.getSpectacleDAO();
		
	// Getters and setters
	
	public int getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	public int getId_planningSalle() {
		return id_planningSalle;
	}
	public void setId_planningSalle(int id_planningSalle) {
		this.id_planningSalle = id_planningSalle;
	}
	
	// Constructor
	
	public Spectacle () {}
	
	public Spectacle (int id_spectacle, String titre, int nbrPlaceParClient, int id_planningSalle) 
	{
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.id_planningSalle = id_planningSalle;
	}
	
	public Spectacle (String titre, int nbrPlaceParClient, int id_planningSalle) 
	{
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.id_planningSalle = id_planningSalle;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a spectacle
	public boolean create() 
	{
		boolean newSpectacle = spectacleDAO.create(this);
		return newSpectacle;
	}
	
	// Methode that we will allows us to find a spectacle
	public Spectacle find()
	{
		Spectacle s = spectacleDAO.find(this); 
		return s;
	}
	
	// Methode that we will allows us to find a spectacle by id
	public Spectacle finById(int id)
	{
		Spectacle s = spectacleDAO.findById(id);
		return s;
	}
	
	// Methode that we will allows to find all spectacle to put in a list
	public ArrayList<Spectacle> findAll()
	{
		ArrayList<Spectacle> listS = spectacleDAO.findAll();
		return listS;
	}
}