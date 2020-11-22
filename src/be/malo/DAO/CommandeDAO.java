package be.malo.DAO;

import java.sql.*;
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
		return obj;
	}
}
