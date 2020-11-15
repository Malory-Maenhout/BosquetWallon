package be.malo.POJO;

import java.util.ArrayList;

public class Spectacle {

	// Attributes/Variables
	
	private int id_spectacle;
	private String titre;
	private ArrayList<Artistes> list_Artistes = new ArrayList();
	private int nbrPlaceParClient;
	
	// Getters and setters
	
	public int getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public ArrayList<Artistes> getList_Artistes() {
		return list_Artistes;
	}
	public void setList_Artistes(ArrayList<Artistes> list_Artistes) {
		this.list_Artistes = list_Artistes;
	}
	
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	// Constructor
	
	public Spectacle () {}
	
	public Spectacle (int id_spectacle, String titre, ArrayList<Artistes> list_Artistes, int nbrPlaceParClient) 
	{
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.list_Artistes = list_Artistes;
		this.nbrPlaceParClient = nbrPlaceParClient;
	}	
}