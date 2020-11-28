package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Gestionnaire;

public class GestionnaireDAO extends DAO<Gestionnaire> {

	public GestionnaireDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Gestionnaire obj){		
		return false;
	}
	
	public boolean delete(Gestionnaire obj){
		return false;
	}
	
	public boolean update(Gestionnaire obj){
		return false;
	}
	
	public Gestionnaire find(Gestionnaire obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Gestionnaire> find(int id){
		return null;
	}

	public Gestionnaire findById(int id){
		return null;
	}

	public ArrayList<Gestionnaire> findAll(){
		return null;
	}

	public Gestionnaire findPsByID(int id) {
		return null;
	}
}