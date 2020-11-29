package be.malo.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import be.malo.POJO.LigneCommande;

public class LigneCommandeDAO extends DAO<LigneCommande>{

	public LigneCommandeDAO(Connection conn){
		super(conn);
	}

	public boolean create(LigneCommande obj){
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO LigneCommande(ID_Cmd, ID_Place)"
					+ "Values('"+ obj.getId_cmd() + "', '" + obj.getId_place() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(LigneCommande obj){
		return false;
	}

	public boolean update(LigneCommande obj){
		return false;
	}

	public LigneCommande find(LigneCommande obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<LigneCommande> find(int id){
		return null;
	}

	public LigneCommande findById(int id){
		return null;
	}

	public ArrayList<LigneCommande> findAll(){
		return null;
	}

	public LigneCommande findPsByID(int id) {
		return null;
	}
}