package be.malo.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import be.malo.POJO.LigneSpectacle;

public class LigneSpectacleDAO extends DAO<LigneSpectacle>{

	public LigneSpectacleDAO(Connection conn){
		super(conn);
	}

	public boolean create(LigneSpectacle obj){
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO LigneSpectacle(ID_LS, ID_Spectacle, ID_Artistes)"
					+ "Values('" + obj.getId_ls() + "', '" + obj.getId_spectacle() + "', '" + obj.getId_artistes() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	public boolean delete(LigneSpectacle obj){
		return false;
	}

	public boolean update(LigneSpectacle obj){
		return false;
	}

	public LigneSpectacle find(LigneSpectacle obj){
		return null;
	}


	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<LigneSpectacle> find(int id){
		return null;
	}

	public LigneSpectacle findById(int id){
		return null;
	}

	public ArrayList<LigneSpectacle> findAll(){
		return null;
	}
}