package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Spectacle obj){		
		return false;
	}
	
	public boolean delete(Spectacle obj){
		return false;
	}
	
	public boolean update(Spectacle obj){
		return false;
	}
	
	public Spectacle find(Spectacle obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Spectacle> find(int id){
		return null;
	}

	public Spectacle findById(int id){
		return null;
	}

	public ArrayList<Spectacle> findAll(){
		return null;
	}

	public Spectacle findByNameAndFirstName(String nomA, String prenomA){
		return null;
	}
}