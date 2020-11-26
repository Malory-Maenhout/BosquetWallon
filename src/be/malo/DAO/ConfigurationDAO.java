package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn){
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
		return null;
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

	public Configuration findByNameAndFirstName(String nomA, String prenomA){
		return null;
	}
}
