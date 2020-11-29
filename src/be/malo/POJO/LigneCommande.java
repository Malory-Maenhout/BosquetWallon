package be.malo.POJO;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class LigneCommande {
	
	// Attributes/Variables
	
	private int id_lc;
	private int id_cmd;
	private int id_place;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<LigneCommande> ligneCommandeDAO = dao.getLigneCommandeDAO();
	
	// Getters and setters
	
	public int getId_lc() {
		return id_lc;
	}
	public void setId_lc(int id_lc) {
		this.id_lc = id_lc;
	}
	public int getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}
	public int getId_place() {
		return id_place;
	}
	public void setId_place(int id_place) {
		this.id_place = id_place;
	}
	
	// Constructor
	
	public LigneCommande() {}
	
	public LigneCommande(int id_lc, int id_cmd, int id_place) 
	{
		this.id_lc = id_lc;
		this.id_cmd = id_cmd;
		this.id_place = id_place;
	}	
	
	public LigneCommande(int id_cmd, int id_place) 
	{
		this.id_cmd = id_cmd;
		this.id_place = id_place;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a ligne order
	public boolean create()
	{
		boolean lc = ligneCommandeDAO.create(this);
		return lc;
	}
}