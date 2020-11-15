package be.malo.POJO;

public class Personne {

	// Attributes/Variables
	
	private int id_personne;
	private String nom;
	private String prenom;
	private String tel;
	private String adresse;
	private String email;
	private String mdp;
	private String type_personne;
	private String ville;
	private String code_postal;
	
	// Getters and setters
	
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getType_personne() {
		return type_personne;
	}
	public void setType_personne(String type_personne) {
		this.type_personne = type_personne;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
	// Constructor

	public Personne () {}
	
	public Personne (int id_personne, String nom, String prenom, String tel, String adresse, String email, String mdp, String type_personne, String ville, String code_postal) 
	{
		this.id_personne = id_personne;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.type_personne = type_personne;
		this.ville = ville;
		this.code_postal = code_postal;
	}
}