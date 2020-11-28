package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Categorie;

public class CategorieDAO extends DAO<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Categorie obj){		
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Categorie(Type_Categorie, Prix, nbrPlaceDispo, nbrPlaceMax, ID_Configuration)"
					+ "Values('" + obj.getType_categorie() + "', '" + obj.getPrix() + "', '" + obj.getNbrPlaceDispo() + "', '" + obj.getNbrPlaceMax() + "', '" + obj.getId_configuration() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
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

	public Categorie findPsByID(int id) {
		return null;
	}
}
