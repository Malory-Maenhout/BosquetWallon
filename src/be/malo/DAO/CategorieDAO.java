package be.malo.DAO;

import java.sql.*;
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
	
	public boolean find(Categorie obj){
		return false;
	}
}
