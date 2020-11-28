package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Artistes;

public class ArtistesDAO extends DAO<Artistes>{

	public ArtistesDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Artistes obj){		
		return false;
	}
	
	public boolean delete(Artistes obj){
		return false;
	}
	
	public boolean update(Artistes obj){
		return false;
	}
	
	public Artistes find(Artistes obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Artistes> find(int id){
		return null;
	}

	public Artistes findById(int id){
		return null;
	}

	public ArrayList<Artistes> findAll(){
		ArrayList<Artistes> ListA = new ArrayList<Artistes>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Type_Personne like 'Artistes'");
			while(result.next())
			{
				Artistes a = new Artistes(result.getInt("ID_Personne"),result.getString("Nom"), result.getString("Prenom"), result.getString("Telephone"),
						result.getString("Adresse"), result.getString("Email"), result.getString("MotDePasse"), result.getString("Type_Personne"), result.getString("Ville"),
						result.getString("CodePostal"));
				ListA.add(a);
			}
			return ListA;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}