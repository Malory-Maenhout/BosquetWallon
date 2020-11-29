package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Commande;
import be.malo.POJO.Place;

public class PlaceDAO extends DAO<Place>{

	public PlaceDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Place obj){		
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Place(NumPlace, ID_Representation, Prix)"
					+ "Values('"+ obj.getNumplace() + "', '" + obj.getId_representation() + "', '" + obj.getPrix() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Place obj){
		return false;
	}
	
	public boolean update(Place obj){
		return false;
	}
	
	public Place find(Place obj){
		Place pl = new Place();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Place WHERE NumPlace = '" + obj.getNumplace() + "' AND ID_Representation = '" + obj.getId_representation() +
							"' AND Prix = '" + obj.getPrix() + "'");
			if(result.last())
				pl = new Place(result.getInt("ID_Place"), result.getInt("NumPLace"), result.getInt("ID_Representation"), result.getDouble("Prix"));
			return pl;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Place> find(int id){
		return null;
	}

	public Place findById(int id){
		return null;
	}

	public ArrayList<Place> findAll(){
		return null;
	}

	public Place findPsByID(int id) {
		return null;
	}
}