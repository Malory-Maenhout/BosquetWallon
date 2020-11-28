package be.malo.POJO;

import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Artistes extends Personne{
	
	// Attributes/Variables
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Artistes> artistesDAO = dao.getArtistesDAO();
	
	// Constructor
	
	public Artistes () {}
	
	public Artistes (int id, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
	
	// Methodes
	
	// Methode that we will allows us that return a list of artistes
	public ArrayList<Artistes> getAllArtistes()
	{
		ArrayList<Artistes> List = artistesDAO.findAll();
		return List;
	}
}