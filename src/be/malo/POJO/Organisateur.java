package be.malo.POJO;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Organisateur extends Personne{
	
	// Attributes/Variables
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Organisateur> organisateurDAO = dao.getOrganisateurDAO();
	
	// Constructor

	public Organisateur () {}
	
	public Organisateur (int id, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
	
	// Methodes 
	
	// Methode that we will allows us to find an organisator by his id
	public Organisateur find(int id)
	{
		Organisateur orga = organisateurDAO.findById(id);
		return orga;
	}
}