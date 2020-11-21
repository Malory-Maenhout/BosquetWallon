package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Personne;

public class PersonneDAO extends DAO<Personne> {
	
	public PersonneDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Personne obj){		
		return false;
	}
	
	public boolean delete(Personne obj){
		return false;
	}
	
	public boolean update(Personne obj){
		return false;
	}
	
	public boolean find(Personne obj){
		return false;
	}
}
