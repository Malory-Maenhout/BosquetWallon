package be.malo.POJO;

import java.util.HashSet;
import java.util.Set;

public class Client extends Personne{
	
	// Attributes/Variables
	
	private Set<Commande> listCommande = new HashSet<>();
	
	// Getters and setters
	
	public Set<Commande> getListCommande() 
	{
		return listCommande;
	}
	public void setListCommande(Set<Commande> listCommande) 
	{
		this.listCommande = listCommande;
	}
	public void addCommande(Commande commande)
	{
		this.listCommande.add(commande);
	}	
	public void removeCommande(Commande commande)
	{
		this.listCommande.remove(commande);
	}
	
	// Constructor
	
	public Client () {}
	
	public Client (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id_personne, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}