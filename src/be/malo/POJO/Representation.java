package be.malo.POJO;

import java.util.Date;
import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Representation {

	// Attributes/Variables
	
	private int id_representation;
	private Date date_debut;
	private Date date_fin;
	private int id_spectacle;
	private Date heure_porte_open;
	
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Representation> representationDAO = dao.getRepresentationDAO();
	
	// Getters and setters
	
	public int getId_representation() {
		return id_representation;
	}
	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
	}
	
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	public Date getHeure_porte_open() {
		return heure_porte_open;
	}
	public void setHeure_porte_open(Date heure_porte_open) {
		this.heure_porte_open = heure_porte_open;
	}
	
	public int getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	
	// Constructor
	
	public Representation () {}
	
	public Representation (int id_representation, Date date_debut, Date date_fin, int id_spectacle, Date heure_porte_open) 
	{
		this.id_representation = id_representation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_spectacle = id_spectacle;
		this.heure_porte_open = heure_porte_open;

	}
	
	public Representation (Date date_debut, Date date_fin, int id_spectacle, Date heure_porte_open) 
	{
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_spectacle = id_spectacle;
		this.heure_porte_open = heure_porte_open;

	}
	
	// Methodes
	
	// Methodes that we will allows us to create a representation
	public boolean create()
	{
		boolean r = representationDAO.create(this);
		return r;
	}	
}