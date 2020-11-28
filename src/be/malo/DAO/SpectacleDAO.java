package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Spectacle obj){		
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Spectacle(Titre, NbrPlaceParClient, ID_PlanningSalle)"
					+ "Values('" + obj.getTitre() + "', '" + obj.getNbrPlaceParClient() + "', '" + obj.getId_planningSalle() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean delete(Spectacle obj){
		return false;
	}
	
	public boolean update(Spectacle obj){
		return false;
	}
	
	public Spectacle find(Spectacle obj){
		Spectacle s = new Spectacle();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Spectacle WHERE Titre = '" + obj.getTitre() + "' AND NbrPlaceParClient = '" + obj.getNbrPlaceParClient() + "' AND ID_PlanningSalle = '" + obj.getId_planningSalle() + "'");
			if(result.first())
				s = new Spectacle(result.getInt("ID_Spectacle"), result.getString("Titre"), result.getInt("NbrPlaceParClient"), result.getInt("ID_PlanningSalle"));
			return s;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Spectacle> find(int id){
		return null;
	}

	public Spectacle findById(int id){
		Spectacle s = new Spectacle();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Spectacle WHERE ID_Spectacle = '" + id + "'");
			if(result.first())
				s = new Spectacle(result.getInt("ID_Spectacle"), result.getString("Titre"), result.getInt("NbrPlaceParClient"), result.getInt("ID_PlanningSalle"));
			return s;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Spectacle> findAll(){
		return null;
	}

	public Spectacle findPsByID(int id) {
		return null;
	}
}