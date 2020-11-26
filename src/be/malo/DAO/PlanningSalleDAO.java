package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle>{
	
	public PlanningSalleDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(PlanningSalle obj){		
		try {	
			Date d1 = obj.getDate_debut();
			Date d2 = obj.getDate_fin();
			Timestamp dt1 = new Timestamp(d1.getYear(), d1.getMonth(), d1.getDate(), 12, 0, 0, 0);
			Timestamp dt2 = new Timestamp(d2.getYear(), d2.getMonth(), d2.getDate(), 12, 0, 0, 0);
			
			this.connect.createStatement().executeUpdate("INSERT INTO PlanningSalle(Date_DebutR, Date_FinR, ID_Reservation, ID_Gestionnaire)"
					+ "Values('"+ dt1 + "', '" + dt2 + "', '" + obj.getId_reservation() + "', '" + obj.getId_gestionnaire() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(PlanningSalle obj){
		return false;
	}
	
	public boolean update(PlanningSalle obj){
		return false;
	}
	
	public PlanningSalle find(PlanningSalle obj){
		return obj;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		try 
		{	
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM PlanningSalle WHERE (Date_DebutR > '" + obj1.toString() + 
							"' AND Date_DebutR < '" + obj2.toString() + "') OR (Date_FinR > '" + obj1.toString() +
							"' AND Date_FinR < '" + obj2.toString() + "') OR (Date_DebutR >= '" + obj1.toString() +
							"' AND Date_FinR <= '" + obj2.toString() + "') OR (Date_DebutR = '" + obj1.toString() +
							"' AND Date_DebutR < '" + obj2.toString() + "' AND Date_FinR > '" + obj2.toString() +
							"') OR (Date_DebutR < '" + obj1.toString() + "' AND Date_FinR > '" + obj1.toString() +
							"' AND Date_FinR = '" + obj2.toString() + "')");
			if(result.first())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<PlanningSalle> find(int id){
		ArrayList<PlanningSalle> ListPlanningSalle = new ArrayList<PlanningSalle>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM PlanningSalle WHERE ID_Gestionnaire = '" + id + "'");
			while(result.next())
			{
				PlanningSalle res = new PlanningSalle(result.getInt("ID_PlanningSalle"), result.getDate("Date_DebutR"), result.getDate("Date_FinR"), result.getInt("ID_Reservation"), result.getInt("ID_Gestionnaire"));
				ListPlanningSalle.add(res);
			}
			return ListPlanningSalle;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public PlanningSalle findById(int id){		
		PlanningSalle ps = new PlanningSalle();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM PlanningSalle WHERE  ID_Reservation = '" + id + "'");
			if(result.first())
			{
				ps = new PlanningSalle(result.getInt("ID_PlanningSalle"), result.getDate("Date_DebutR"), result.getDate("Date_FinR"), result.getInt("ID_Reservation"), result.getInt("ID_Gestionnaire"));
				return ps;
			}
			else
			{
				return null;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<PlanningSalle> findAll(){
		return null;
	}

	public PlanningSalle findByNameAndFirstName(String nomA, String prenomA){
		return null;
	}
}
