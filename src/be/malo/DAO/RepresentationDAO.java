package be.malo.DAO;

import java.sql.*;
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
		return obj;
	}
}
