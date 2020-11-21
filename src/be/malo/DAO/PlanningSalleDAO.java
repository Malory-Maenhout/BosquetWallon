package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle>{
	
	public PlanningSalleDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(PlanningSalle obj){		
		return false;
	}
	
	public boolean delete(PlanningSalle obj){
		return false;
	}
	
	public boolean update(PlanningSalle obj){
		return false;
	}
	
	public boolean find(PlanningSalle obj){
		return false;
	}
}
