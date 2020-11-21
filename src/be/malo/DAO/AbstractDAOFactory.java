package be.malo.DAO;

import be.malo.POJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Artistes> getArtistesDAO();
	public abstract DAO<Categorie> getCategorieDAO();
	public abstract DAO<Client> getClientDAO();
	public abstract DAO<Commande> getCommandeDAO();
	public abstract DAO<Configuration> getConfigurationDAO();
	public abstract DAO<Gestionnaire> getGestionnaireDAO();
	public abstract DAO<Organisateur> getOrganisateurDAO();
	public abstract DAO<Personne> getPersonneDAO();
	public abstract DAO<Place> getPlaceDAO();
	public abstract DAO<PlanningSalle> getPlanningSalleDAO();
	public abstract DAO<Representation> getRepresentationDAO();
	public abstract DAO<Reservation> getReservationDAOO();
	public abstract DAO<Spectacle> getSpectacleDAO();
	
	public static AbstractDAOFactory getFactory(int type)
	{
		switch(type)
		{
			case DAO_FACTORY:
				return new DAOFactory();
			default:
				return null;
		}
	}
}
