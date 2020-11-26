package be.malo.POJO;

public class Client extends Personne{
	
	// Constructor
	
	public Client () {}
	
	public Client (int id, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal)
	{
		super(id, nom, prenom, tel, adresse, email, mdp, type_personne, ville, code_postal);
	}
}