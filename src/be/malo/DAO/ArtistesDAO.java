package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Artistes;

public class ArtistesDAO extends DAO<Artistes>{

	public ArtistesDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Artistes obj){		
		return false;
	}
	
	public boolean delete(Artistes obj){
		return false;
	}
	
	public boolean update(Artistes obj){
		return false;
	}
	
	public Artistes find(Artistes obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Artistes> find(int id){
		return null;
	}

	public Artistes findById(int id){
		return null;
	}
}
