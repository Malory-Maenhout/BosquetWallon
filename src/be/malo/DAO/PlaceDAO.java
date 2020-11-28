package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Place;

public class PlaceDAO extends DAO<Place>{

	public PlaceDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Place obj){		
		return false;
	}
	
	public boolean delete(Place obj){
		return false;
	}
	
	public boolean update(Place obj){
		return false;
	}
	
	public Place find(Place obj){
		return null;
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
}