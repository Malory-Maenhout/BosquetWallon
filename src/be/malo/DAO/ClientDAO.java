package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Client;

public class ClientDAO extends DAO<Client>{

	public ClientDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Client obj){		
		return false;
	}
	
	public boolean delete(Client obj){
		return false;
	}
	
	public boolean update(Client obj){
		return false;
	}
	
	public Client find(Client obj){
		return obj;
	}
}
