package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Commande;

public class CommandeDAO extends DAO<Commande> {
	
	public CommandeDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Commande obj){		
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Commande(ID_Personne, Mode_Payement, Mode_Livraison, Prix_Total)"
					+ "Values('"+ obj.getId_client() + "', '" + obj.getMode_paiement() + "', '" + obj.getMode_livraison() + "', '" + obj.getPrix_total() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Commande obj){
		return false;
	}
	
	public boolean update(Commande obj){
		return false;
	}
	
	public Commande find(Commande obj){
		Commande com = new Commande();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Commande WHERE ID_Personne = '" + obj.getId_client() + "' AND Mode_Payement = '" + obj.getMode_paiement() +
							"' AND Mode_Livraison = '"+ obj.getMode_livraison() + "' AND Prix_Total = '"+ obj.getPrix_total() + "'");
			if(result.last())
				com = new Commande(result.getInt("ID_Cmd"), result.getInt("ID_Personne"), result.getString("Mode_Payement"), result.getString("Mode_Livraison"), result.getDouble("Prix_Total"));
			return com;
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

	public ArrayList<Commande> find(int id){
		ArrayList<Commande> ListCom = new ArrayList<Commande>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Commande WHERE ID_Personne = '" + id + "'");
			while(result.next())
			{
				Commande com = new Commande(result.getInt("ID_Cmd"), result.getInt("ID_Personne"), result.getString("Mode_Payement"), result.getString("Mode_Livraison"), result.getDouble("Prix_Total"));
				ListCom.add(com);
			}
			return ListCom;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Commande findById(int id){
		return null;
	}

	public ArrayList<Commande> findAll(){
		return null;
	}

	public Commande findPsByID(int id) {
		return null;
	}
}