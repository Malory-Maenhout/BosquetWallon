package be.malo.POJO;

public class Configuration {

	// Attributes/Variables
	
	private int id_configuration;
	private String type_configuration;
	private String Description;
	
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
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	// Constructor
	
	public Configuration () {}
	
	public Configuration (int id_configuration, String type_configuration, String description) 
	{
		this.id_configuration = id_configuration;
		this.type_configuration = type_configuration;
		Description = description;
	}
	
	
}
