package be.malo.POJO;

import java.util.ArrayList;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Commande {

	// Attributes/Variables
	
	private int id_cmd;
	private int id_client;
	private String mode_paiement;
	private String mode_livraison;
	private double prix_total;
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Commande> commandeDAO = dao.getCommandeDAO();
	
	// Getters and setters
	
	public int getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	public String getMode_paiement() {
		return mode_paiement;
	}
	public void setMode_paiement(String mode_paiement) {
		this.mode_paiement = mode_paiement;
	}
	
	public String getMode_livraison() {
		return mode_livraison;
	}
	public void setMode_livraison(String mode_livraison) {
		this.mode_livraison = mode_livraison;
	}
	
	public double getPrix_total() {
		return prix_total;
	}
	public void setPrix_total(double prix_total) {
		this.prix_total = prix_total;
	}
	
	// Constructor
	
	public Commande () {}
	
	public Commande (int id_cmd, int id_client, String mode_paiement, String mode_livraison, double prix_total) 
	{
		this.id_cmd = id_cmd;
		this.id_client = id_client;
		this.mode_paiement = mode_paiement;
		this.mode_livraison = mode_livraison;
		this.prix_total = prix_total;
	}
	
	public Commande (int id_client, String mode_paiement, String mode_livraison, double prix_total) 
	{
		this.id_client = id_client;
		this.mode_paiement = mode_paiement;
		this.mode_livraison = mode_livraison;
		this.prix_total = prix_total;
	}
	
	// Methodes
	
	// Methode that we will allows us to create an order
	public boolean create ()
	{
		boolean x = commandeDAO.create(this);
		return x;
	}
	
	// Methode that we will allows us to find an order
	public Commande find() 
	{
		Commande com = commandeDAO.find(this);
		return com;
	}
	
	// Methode that we will allows us to return a list of order by id client
	public ArrayList<Commande> getList(int id)
	{
		ArrayList<Commande> lc = commandeDAO.find(id);
		return lc;
	}
}