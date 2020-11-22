package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Gestionnaire;

public class GestionnaireDAO extends DAO<Gestionnaire> {

	public GestionnaireDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Gestionnaire obj){		
		return false;
	}
	
	public boolean delete(Gestionnaire obj){
		return false;
	}
	
	public boolean update(Gestionnaire obj){
		return false;
	}
	
	public Gestionnaire find(Gestionnaire obj){
		return obj;
	}
}