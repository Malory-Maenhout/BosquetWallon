package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Reservation;

public class ReservationDAO extends DAO<Reservation> {

	public ReservationDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Reservation obj){		
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Reservation(Prix_Total, ID_Organisateur)"
					+ "Values('"+ obj.getPrix_total() + "', '" + obj.getId_organisateur() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Reservation obj){
		return false;
	}
	
	public boolean update(Reservation obj){
		return false;
	}
	
	public Reservation find(Reservation obj){
		Reservation reservation = new Reservation();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE Prix_Total = '" + obj.getPrix_total() + "' AND ID_Organisateur = '" + obj.getId_organisateur() + "'");
			if(result.last())
				reservation = new Reservation(result.getInt("ID_Reservation"), result.getDouble("Prix_Total"), result.getInt("ID_Organisateur"));
			return reservation;
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

	public ArrayList<Reservation> find(int id){	
		ArrayList<Reservation> ListReservation = new ArrayList<Reservation>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE  ID_Organisateur = '" + id + "'");
			while(result.next())
			{
				Reservation res = new Reservation(result.getInt("ID_Reservation"), result.getDouble("Prix_Total"), result.getInt("ID_Organisateur"));
				ListReservation.add(res);
			}
			return ListReservation;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Reservation findById(int id){
		Reservation r = new Reservation();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Reservation WHERE  ID_Reservation = '" + id + "'");
			if(result.first())
			{
				r = new Reservation(result.getInt("ID_Reservation"), result.getDouble("Prix_Total"), result.getInt("ID_Organisateur"));
				return r;
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

	public ArrayList<Reservation> findAll(){
		return null;
	}

	public Reservation findPsByID(int id) {
		return null;
	}
}