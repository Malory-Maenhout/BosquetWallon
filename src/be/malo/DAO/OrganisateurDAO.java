package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Organisateur;


public class OrganisateurDAO extends DAO<Organisateur>{
	
	public OrganisateurDAO(Connection conn){
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
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Organisateur> find(int id){
		return null;
	}

	public Organisateur findById(int id){
		return null;
	}

	public ArrayList<Organisateur> findAll(){
		return null;
	}

	public Organisateur findPsByID(int id) {
		return null;
	}
}