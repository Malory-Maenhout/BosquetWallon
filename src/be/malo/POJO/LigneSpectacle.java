package be.malo.POJO;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class LigneSpectacle {

	// Attributes/Variables
	
	private int id_ls;
	private int id_spectacle;
	private int id_artistes;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<LigneSpectacle> ligneSpectacleDAO = dao.getLigneSpectacleDAO();
	
	// Getters and setters
	
	public int getId_ls() {
		return id_ls;
	}
	public void setId_ls(int id_ls) {
		this.id_ls = id_ls;
	}
	public int getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	public int getId_artistes() {
		return id_artistes;
	}
	public void setId_artistes(int id_artistes) {
		this.id_artistes = id_artistes;
	}
	
	// Constructeur
	
	public LigneSpectacle() {}
	
	public LigneSpectacle(int id_ls, int id_spectacle, int id_artistes) 
	{
		this.id_ls = id_ls;
		this.id_spectacle = id_spectacle;
		this.id_artistes = id_artistes;
	}	
	
	public LigneSpectacle(int id_spectacle, int id_artistes) 
	{
		this.id_spectacle = id_spectacle;
		this.id_artistes = id_artistes;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a LigneSpectacle
	public boolean create()
	{
		boolean ls = ligneSpectacleDAO.create(this);
		return ls;
	}
}
