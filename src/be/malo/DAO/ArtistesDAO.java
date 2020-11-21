package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Artistes;

public class ArtistesDAO extends DAO<Artistes>{

	public ArtistesDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Artistes obj){		
		return false;
	}
	
	public boolean delete(Artistes obj){
		return false;
	}
	
	public boolean update(Artistes obj){
		return false;
	}
	
	public boolean find(Artistes obj){
		return false;
	}
}
