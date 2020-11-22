package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Place;

public class PlaceDAO extends DAO<Place>{

	public PlaceDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Place obj){		
		return false;
	}
	
	public boolean delete(Place obj){
		return false;
	}
	
	public boolean update(Place obj){
		return false;
	}
	
	public Place find(Place obj){
		return obj;
	}
}
