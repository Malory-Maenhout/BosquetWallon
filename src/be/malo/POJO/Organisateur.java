package be.malo.POJO;

public class Organisateur extends Personne{

	// Constructor
	
	public Organisateur () {}
	
	public Organisateur (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id_personne, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}