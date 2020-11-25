package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Commande;

public class CommandeDAO extends DAO<Commande> {
	
	public CommandeDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Commande obj){		
		return false;
	}
	
	public boolean delete(Commande obj){
		return false;
	}
	
	public boolean update(Commande obj){
		return false;
	}
	
	public Commande find(Commande obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Commande> find(int id){
		return null;
	}

	public Commande findById(int id){
		return null;
	}
}
