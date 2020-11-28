package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Configuration obj){		
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Configuration(Type_Configuration, Description, ID_Spectacle)"
					+ "Values('" + obj.getType_configuration() + "', '" + obj.getDescription() + "', '" + obj.getId_spectacle() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean delete(Configuration obj){
		return false;
	}
	
	public boolean update(Configuration obj){
		return false;
	}
	
	public Configuration find(Configuration obj){
		Configuration c = new Configuration();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Configuration WHERE Type_Configuration = '" + obj.getType_configuration() + "' AND Description = '" + obj.getDescription() + "' AND ID_Spectacle = '" + obj.getId_spectacle() + "'");
			if(result.first())
				c = new Configuration(result.getInt("ID_Configuration"), result.getString("Type_Configuration"), result.getString("Description"), result.getInt("ID_Spectacle"));
			return c;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Configuration> find(int id){
		return null;
	}

	public Configuration findById(int id){
		return null;
	}

	public ArrayList<Configuration> findAll(){
		return null;
	}
}