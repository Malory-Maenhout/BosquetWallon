package be.malo.POJO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Spectacle {

	// Attributes/Variables
	
	private int id_spectacle;
	private String titre;
	private int nbrPlaceParClient;
	private PlanningSalle id_planningSalle;
	private ArrayList<Artistes> list_Artistes = new ArrayList();
	private Set<Representation> listRepresentation = new HashSet<>();
		
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
	
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	
	public PlanningSalle getId_planningSalle() {
		return id_planningSalle;
	}
	public void setId_planningSalle(PlanningSalle id_planningSalle) {
		this.id_planningSalle = id_planningSalle;
	}
	
	public ArrayList<Artistes> getList_Artistes() {
		return list_Artistes;
	}
	public void setList_Artistes(ArrayList<Artistes> list_Artistes) {
		this.list_Artistes = list_Artistes;
	}
	
	public Set<Representation> getListRepresentation()
	{
		return listRepresentation;
	}
	public void setListRepresentation(Set<Representation> listRepresentation) 
	{
		this.listRepresentation = listRepresentation;
	}
	public void addRepresentation(Representation representation)
	{
		this.listRepresentation.add(representation);
	}	
	public void removeRepresentation(Representation representation)
	{
		this.listRepresentation.remove(representation);
	}
	
	// Constructor
	
	public Spectacle () {}
	
	public Spectacle (int id_spectacle, String titre, int nbrPlaceParClient, PlanningSalle id_planningSalle, ArrayList<Artistes> list_Artistes) 
	{
		this.id_spectacle = id_spectacle;
		this.titre = titre;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.id_planningSalle = id_planningSalle;
		this.list_Artistes = list_Artistes;
	}
}