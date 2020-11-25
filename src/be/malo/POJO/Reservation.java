package be.malo.POJO;

import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Reservation {

	// Attributes/Variables
	
	private int id_reservation;
	private double prix_total;
	private int id_organisateur;

	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Reservation> reservationDAO = dao.getReservationDAO();
	
	// Getters and setters
	
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	
	public int getId_organisateur() {
		return id_organisateur;
	}
	public void setId_organisateur(int id_organisateur) {
		this.id_organisateur = id_organisateur;
	}
	
	// Constructor

	public Reservation () {}
	
	public Reservation (double prix_total, int id_organisateur) 
	{
		this.prix_total = prix_total;
		this.id_organisateur = id_organisateur;
	}
	
	public Reservation (int id_reservation, double prix_total, int id_organisateur) 
	{
		this.id_reservation = id_reservation;
		this.prix_total = prix_total;
		this.id_organisateur = id_organisateur;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a reservation
	public boolean create()
	{
		boolean newPlanningSalle = reservationDAO.create(this);
		return newPlanningSalle;
	}
	
	// Methode that we will allows us to find a reservaion
	public Reservation find()
	{
		Reservation fr = reservationDAO.find(this);
		return fr;
	}
	
	// Methode that we will allows us to get a list of reservation by id of organisator
	public ArrayList<Reservation> getList(int id)
	{
		ArrayList<Reservation> List = new ArrayList<Reservation>(reservationDAO.find(id));
		return List;
	}
	
	// Methode that we will allows us to find a reservation by id
	public Reservation getRes(int id)
	{
		Reservation r = reservationDAO.findById(id);
		return r;
	}
}