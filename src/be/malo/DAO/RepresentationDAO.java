package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Representation;
import be.malo.POJO.Spectacle;

public class RepresentationDAO extends DAO<Representation>{
	
	public RepresentationDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Representation obj){		
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Representation(Date_Debut, Date_Fin, ID_Spectacle, Heure_Porte_Open)"
					+ "Values('" + obj.getDate_debut() + "', '" + obj.getDate_fin() + "', '" + obj.getId_spectacle() + "', '" + obj.getHeure_porte_open() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Representation obj){
		return false;
	}
	
	public boolean update(Representation obj){
		return false;
	}
	
	public Representation find(Representation obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Representation> find(int id){
		ArrayList<Representation> ListR = new ArrayList<Representation>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Representation WHERE ID_Spectacle = '" + id + "'");
			while(result.next())
			{
				Representation r = new Representation(result.getInt("ID_Representation"), result.getDate("Date_Debut"), result.getDate("Date_Fin"), result.getInt("ID_Spectacle"), result.getDate("Heure_Porte_Open"));
				ListR.add(r);
			}
			return ListR;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Representation findById(int id){
		return null;
	}

	public ArrayList<Representation> findAll(){
		return null;
	}

	public Representation findPsByID(int id) {
		return null;
	}
}