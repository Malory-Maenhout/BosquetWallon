package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Representation;

public class RepresentationDAO extends DAO<Representation>{
	
	public RepresentationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Representation obj){		
		return false;
	}
	
	public boolean delete(Representation obj){
		return false;
	}
	
	public boolean update(Representation obj){
		return false;
	}
	
	public Representation find(Representation obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Representation> find(int id) {
		return null;
	}

	public Representation findById(int id) {
		return null;
	}
}
