package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Categorie;

public class CategorieDAO extends DAO<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Categorie obj){		
		return false;
	}
	
	public boolean delete(Categorie obj){
		return false;
	}
	
	public boolean update(Categorie obj){
		return false;
	}
	
	public Categorie find(Categorie obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Categorie> find(int id){
		return null;
	}

	public Categorie findById(int id){
		return null;
	}

	public ArrayList<Categorie> findAll(){
		return null;
	}

	public Categorie findByNameAndFirstName(String nomA, String prenomA) {
		return null;
	}
}
