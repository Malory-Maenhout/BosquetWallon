package be.malo.POJO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Representation {

	// Attributes/Variables
	
	private int id_representation;
	private Date date_debut;
	private Date date_fin;
	private Date heure_porte_open;
	private Spectacle id_spectacle;
	private Set<Place> listPlace = new HashSet<>();
	
	// Getters and setters
	
	public int getId_representation() {
		return id_representation;
	}
	public void setId_representation(int id_representation) {
		this.id_representation = id_representation;
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
	
	public Date getHeure_porte_open() {
		return heure_porte_open;
	}
	public void setHeure_porte_open(Date heure_porte_open) {
		this.heure_porte_open = heure_porte_open;
	}
	
	public Spectacle getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(Spectacle id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	
	public Set<Place> getListPlace() 
	{
		return listPlace;
	}
	public void setListPlace(Set<Place> listPlace) 
	{
		this.listPlace = listPlace;
	}
	public void addPlace(Place place)
	{
		this.listPlace.add(place);
	}	
	public void removeSpectacle(Place place)
	{
		this.listPlace.remove(place);
	}
	
	// Constructor
	
	public Representation () {}
	
	public Representation (int id_representation, Date date_debut, Date date_fin, Date heure_porte_open, Spectacle id_spectacle) 
	{
		this.id_representation = id_representation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.heure_porte_open = heure_porte_open;
		this.id_spectacle = id_spectacle;
	}
}