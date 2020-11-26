package be.malo.DAO;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

public abstract class DAO<T> {
	
	protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(T obj);
	
	public abstract boolean find(Timestamp obj1, Timestamp obj2);
	
	public abstract ArrayList<T> find(int id);
	
	public abstract T findById(int id);
	
	public abstract ArrayList<T> findAll();
	
	public abstract T findByNameAndFirstName(String nomA, String prenomA);
}
