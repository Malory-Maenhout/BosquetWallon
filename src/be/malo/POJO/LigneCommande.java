package be.malo.POJO;

public class LigneCommande {
	
	// Attributes/Variables
	
	private int id_lc;
	private Commande id_cmd;
	private Representation id_place;
	
	// Getters and setters
	
	public int getId_lc() {
		return id_lc;
	}
	public void setId_lc(int id_lc) {
		this.id_lc = id_lc;
	}
	public Commande getId_cmd() {
		return id_cmd;
	}
	public void setId_cmd(Commande id_cmd) {
		this.id_cmd = id_cmd;
	}
	public Representation getId_place() {
		return id_place;
	}
	public void setId_place(Representation id_place) {
		this.id_place = id_place;
	}
	
	// Constructor
	
	public LigneCommande() {}
	
	public LigneCommande(int id_lc, Commande id_cmd, Representation id_place) 
	{
		this.id_lc = id_lc;
		this.id_cmd = id_cmd;
		this.id_place = id_place;
	}	
}