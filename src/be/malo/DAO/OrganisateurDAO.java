package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;
import be.malo.POJO.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur>{
	
	public OrganisateurDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Organisateur obj){		
		return false;
	}
	
	public boolean delete(Organisateur obj){
		return false;
	}
	
	public boolean update(Organisateur obj){
		return false;
	}
	
	public Organisateur find(Organisateur obj){
		return null;
	}

	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<Organisateur> find(int id){
		return null;
	}

	public Organisateur findById(int id){
		Organisateur orga = new Organisateur();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE  ID_Personne = '" + id + "'");
			if(result.first())
			{
				orga = new Organisateur(result.getInt("ID_Personne"),result.getString("Nom"), result.getString("Prenom"), result.getString("Telephone"),
						result.getString("Adresse"), result.getString("Email"), result.getString("MotDePasse"), result.getString("Type_Personne"), result.getString("Ville"),
						result.getString("CodePostal"));
				return orga;
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

	public ArrayList<Organisateur> findAll(){
		return null;
	}

	public Organisateur findPsByID(int id) {
		return null;
	}
}