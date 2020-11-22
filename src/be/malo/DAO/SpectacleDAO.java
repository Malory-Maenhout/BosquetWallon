package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Spectacle obj){		
		return false;
	}
	
	public boolean delete(Spectacle obj){
		return false;
	}
	
	public boolean update(Spectacle obj){
		return false;
	}
	
	public Spectacle find(Spectacle obj){
		return obj;
	}
}
