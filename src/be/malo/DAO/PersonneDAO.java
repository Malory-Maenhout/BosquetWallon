package be.malo.DAO;

import java.sql.*;
import java.util.ArrayList;

import be.malo.POJO.Personne;

public class PersonneDAO extends DAO<Personne> {
	
	public PersonneDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Personne obj){	
		try {
			this.connect.createStatement().executeUpdate("INSERT INTO Personne(Nom, Prenom, Telephone, Adresse, Email, MotDePasse, Type_Personne, Ville, CodePostal)"
					+ "Values('"+ obj.getNom() + "', '" + obj.getPrenom() + "', '" + obj.getTel() + "', '" + obj.getAdresse() 
					+ "', '" + obj.getEmail() + "', '" + obj.getMdp() + "', '" + obj.getType_personne() + "', '" 
					+ obj.getVille() + "', '" + obj.getCode_postal() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean delete(Personne obj){
		return false;
	}
	
	public boolean update(Personne obj){
		return false;
	}
	
	public Personne find(Personne obj){
		Personne poeple = new Personne();
		try {
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne WHERE Email = '" + obj.getEmail() + "' AND MotDePasse = '" + obj.getMdp()+ "'");
			if(result.first())
				poeple = new Personne(result.getInt("ID_Personne"),result.getString("Nom"), result.getString("Prenom"), result.getString("Telephone"),
						result.getString("Adresse"), obj.getEmail(), obj.getMdp(), result.getString("Type_Personne"), result.getString("Ville"),
						result.getString("CodePostal"));
			return poeple;
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

	public ArrayList<Personne> find(int id) {
		return null;
	}

	public Personne findById(int id) {
		return null;
	}
}