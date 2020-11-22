package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Configuration obj){		
		return false;
	}
	
	public boolean delete(Configuration obj){
		return false;
	}
	
	public boolean update(Configuration obj){
		return false;
	}
	
	public Configuration find(Configuration obj){
		return obj;
	}
}
