package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur>{
	
	public OrganisateurDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Organisateur obj){		
		return false;
	}
	
	public boolean delete(Organisateur obj){
		return false;
	}
	
	public boolean update(Organisateur obj){
		return false;
	}
	
	public Organisateur find(Organisateur obj){
		return obj;
	}
}
