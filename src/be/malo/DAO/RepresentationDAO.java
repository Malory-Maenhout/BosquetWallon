package be.malo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.ArrayList;
import be.malo.POJO.Representation;

public class RepresentationDAO extends DAO<Representation>{
	
	public RepresentationDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Representation obj){		
		try 
		{
			Date d1 = obj.getDate_debut();
			Date d2 = obj.getDate_fin();
			Date d3 = obj.getHeure_porte_open();
			Timestamp dt1 = new Timestamp(d1.getYear(), d1.getMonth(), d1.getDate(), d1.getHours(), d1.getMinutes(), 0, 0);
			Timestamp dt2 = new Timestamp(d2.getYear(), d2.getMonth(), d2.getDate(), d2.getHours(), d2.getMinutes(), 0, 0);
			Timestamp dt3 = new Timestamp(d3.getYear(), d3.getMonth(), d3.getDate(), d3.getHours(), d3.getMinutes(), 0, 0);
			this.connect.createStatement().executeUpdate("INSERT INTO Representation(Date_Debut, Date_Fin, ID_Spectacle, Heure_Porte_Open)"
					+ "Values('" + dt1 + "', '" + dt2 + "', '" + obj.getId_spectacle() + "', '" + dt3 + "')");
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
				Timestamp dd = new Timestamp(result.getDate("Date_Debut").getYear(), result.getDate("Date_Debut").getMonth(), result.getDate("Date_Debut").getDate(), result.getTime("Date_Debut").getHours(), result.getTime("Date_Debut").getMinutes(), 0, 0);
				Timestamp df = new Timestamp(result.getDate("Date_Fin").getYear(), result.getDate("Date_Fin").getMonth(), result.getDate("Date_Fin").getDate(), result.getTime("Date_Fin").getHours(), result.getTime("Date_Fin").getMinutes(), 0, 0);
				Timestamp ho = new Timestamp(result.getDate("Heure_Porte_Open").getYear(), result.getDate("Heure_Porte_Open").getMonth(), result.getDate("Heure_Porte_Open").getDate(), result.getTime("Heure_Porte_Open").getHours(), result.getTime("Heure_Porte_Open").getMinutes(), 0, 0);
				Date ddf = new Date(dd.getTime());
				Date dff = new Date(df.getTime());
				Date hof = new Date(ho.getTime());
				Representation r = new Representation(result.getInt("ID_Representation"), ddf, dff, result.getInt("ID_Spectacle"), hof);
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