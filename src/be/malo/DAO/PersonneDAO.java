package be.malo.DAO;

import java.sql.*;
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
	
	public boolean find(Personne obj){
		return false;
	}
}
