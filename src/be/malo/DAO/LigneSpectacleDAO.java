package be.malo.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import be.malo.POJO.LigneSpectacle;

public class LigneSpectacleDAO extends DAO<LigneSpectacle>{

	public LigneSpectacleDAO(Connection conn){
		super(conn);
	}

	public boolean create(LigneSpectacle obj){
		try 
		{
			this.connect.createStatement().executeUpdate("INSERT INTO LigneSpectacle(ID_LS, ID_Spectacle, ID_Artistes)"
					+ "Values('" + obj.getId_ls() + "', '" + obj.getId_spectacle() + "', '" + obj.getId_artistes() + "')");
			return true;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	public boolean delete(LigneSpectacle obj){
		return false;
	}

	public boolean update(LigneSpectacle obj){
		return false;
	}

	public LigneSpectacle find(LigneSpectacle obj){
		return null;
	}


	public boolean find(Timestamp obj1, Timestamp obj2){
		return false;
	}

	public ArrayList<LigneSpectacle> find(int id){
		ArrayList<LigneSpectacle> ListSpectacle = new ArrayList<LigneSpectacle>();
		try 
		{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM LigneSpectacle WHERE  ID_Artistes = '" + id + "'");
			while(result.next())
			{
				LigneSpectacle res = new LigneSpectacle(result.getInt("ID_LS"), result.getInt("ID_Spectacle"), result.getInt("ID_Artistes"));
				ListSpectacle.add(res);
			}
			return ListSpectacle;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public LigneSpectacle findById(int id){
		return null;
	}

	public ArrayList<LigneSpectacle> findAll(){
		return null;
	}

	public LigneSpectacle findPsByID(int id) {
		return null;
	}
}