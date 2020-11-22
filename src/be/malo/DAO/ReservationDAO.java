package be.malo.DAO;

import java.sql.*;
import be.malo.POJO.Reservation;

public class ReservationDAO extends DAO<Reservation> {

	public ReservationDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Reservation obj){		
		return false;
	}
	
	public boolean delete(Reservation obj){
		return false;
	}
	
	public boolean update(Reservation obj){
		return false;
	}
	
	public Reservation find(Reservation obj){
		return obj;
	}
}
