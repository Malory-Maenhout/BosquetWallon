package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Categorie;

public class CategorieDAO extends DAO<Categorie> {

	public CategorieDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Categorie obj){		
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO Categorie(Type_Categorie, Prix, nbrPlaceDispo, nbrPlaceMax, ID_Configuration)"
					+ "Values('" + obj.getType_categorie() + "', '" + obj.getPrix() + "', '" + obj.getNbrPlaceDispo() + "', '" + obj.getNbrPlaceMax() + "', '" + obj.getId_configuration() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Categorie obj){
		return false;
	}
	
	public boolean update(Categorie obj){
		try 
		{
			this.connect.createStatement().executeUpdate("UPDATE Categorie SET nbrPlaceDispo = '" + obj.getNbrPlaceDispo() + "' Where ID_Categorie = '" + obj.getId_categorie() + "'");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public Categorie find(Categorie obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Categorie> find(int id){
		ArrayList<Categorie> ListCat = new ArrayList<Categorie>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Categorie WHERE ID_Configuration = '" + id + "'");
			while(result.next())
			{
				Categorie cat = new Categorie(result.getInt("ID_Categorie"), result.getString("Type_Categorie"), result.getDouble("Prix"), result.getInt("nbrPlaceDispo"), result.getInt("nbrPlaceMax"), result.getInt("ID_Configuration"));
				ListCat.add(cat);
			}
			return ListCat;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public Categorie findById(int id){
		return null;
	}

	public ArrayList<Categorie> findAll(){
		return null;
	}

	public Categorie findPsByID(int id) {
		return null;
	}
}
