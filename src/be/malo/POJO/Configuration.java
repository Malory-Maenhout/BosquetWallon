package be.malo.POJO;

import be.malo.DAO.AbstractDAOFactory;
import be.malo.DAO.DAO;

public class Configuration {

	// Attributes/Variables
	
	private int id_configuration;
	private String type_configuration;
	private String description;
	private int id_spectacle;	
	
	private static AbstractDAOFactory dao = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	private static DAO<Configuration> configurationDAO = dao.getConfigurationDAO();
	
	// Getters and setters
	
	public int getId_configuration() {
		return id_configuration;
	}
	public void setId_configuration(int id_configuration) {
		this.id_configuration = id_configuration;
	}
	
	public String getType_configuration() {
		return type_configuration;
	}
	public void setType_configuration(String type_configuration) {
		this.type_configuration = type_configuration;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getId_spectacle() {
		return id_spectacle;
	}
	public void setId_spectacle(int id_spectacle) {
		this.id_spectacle = id_spectacle;
	}
	
	// Constructor
	
	public Configuration () {}
	
	public Configuration (int id_configuration, String type_configuration, String description, int id_spectacle) 
	{
		this.id_configuration = id_configuration;
		this.type_configuration = type_configuration;
		this.description = description;
		this.id_spectacle = id_spectacle;
	}	
	
	public Configuration (String type_configuration, String description, int id_spectacle) 
	{
		this.type_configuration = type_configuration;
		this.description = description;
		this.id_spectacle = id_spectacle;
	}
	
	// Methodes
	
	// Methode that we will allows us to create a configuration
	public boolean create()
	{
		boolean conf = configurationDAO.create(this);
		return conf;
	}
	
	// Methodes that we will allow us to find the configuration
	public Configuration find()
	{
		Configuration c = configurationDAO.find(this);
		return c;
	}
	
	// Methodes that we will allow us to find the configuration by id spectacle
	public Configuration findById(int id)
	{
		Configuration c = configurationDAO.findById(id);
		return c;
	}
}