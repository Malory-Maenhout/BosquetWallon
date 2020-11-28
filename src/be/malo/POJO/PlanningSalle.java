package be.malo.POJO;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class PlanningSalle {
	
	// Attributes/Variables
	
	private int id_planningsalle;
	private Date date_debut;
	private Date date_fin;
	private int id_reservation;
	private int id_gestionnaire;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<PlanningSalle> planningSalleDAO = dao.getPlanningSalleDAO();
	
	// Getters and setters
	
	public int getId_planningsalle() {
		return id_planningsalle;
	}
	public void setId_planningsalle(int id_planningsalle) {
		this.id_planningsalle = id_planningsalle;
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
	
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	public int getId_gestionnaire() {
		return id_gestionnaire;
	}
	public void setId_gestionnaire(int id_gestionnaire) {
		this.id_gestionnaire = id_gestionnaire;
	}
	
	// Constructor
	
	public PlanningSalle () {}
	
	public PlanningSalle (Date date_debut, Date date_fin, int id_reservation, int id_gestionnaire) 
	{
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_reservation = id_reservation;
		this.id_gestionnaire = id_gestionnaire;
	}
	
	public PlanningSalle (int id_planningsalle, Date date_debut, Date date_fin, int id_reservation, int id_gestionnaire) 
	{
		this.id_planningsalle = id_planningsalle;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_reservation = id_reservation;
		this.id_gestionnaire = id_gestionnaire;
	}
	
	// Methodes
	
	// Methode that we will allows us to check if a planning room is not yet records
	public boolean verify(Timestamp start, Timestamp end)
	{
		boolean check = planningSalleDAO.find(start, end);
		return check;
	}
	
	// Methode that we will allows us to create a PlanningSalle
	public boolean create()
	{
		boolean newPlanningSalle = planningSalleDAO.create(this);
		return newPlanningSalle;
	}
	
	// Methode that we will allows us to find a planningSalle by id reservation
	public PlanningSalle getPS(int id)
	{
		PlanningSalle ps = planningSalleDAO.findById(id);
		return ps;
	}
	
	// Methode that we will allows us to get a list of planning room by id of gestionnaire
	public ArrayList<PlanningSalle> getList(int id)
	{
		ArrayList<PlanningSalle> List = new ArrayList<PlanningSalle>(planningSalleDAO.find(id));
		return List;
	}
	
	// Methode that we will allows us to get all data about planning room
	public PlanningSalle find()
	{
		PlanningSalle ps = planningSalleDAO.find(this);
		return ps;
	}
	
	// Methode that we will allows us to find a planningSalle by id
	public PlanningSalle getById(int id)
	{
		PlanningSalle ps = planningSalleDAO.findPsByID(id);
		return ps;
	}
}