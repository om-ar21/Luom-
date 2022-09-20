package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Coordonnees;
import model.Database;

public class CoordonneesDAO {
	public ArrayList<Coordonnees> getAll() {
		ArrayList<Coordonnees> list = new ArrayList<Coordonnees>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM coordonnees WHERE del=0");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Coordonnees o = new Coordonnees();
					o.setId(resultat.getInt( "id" ));
					o.setNom(resultat.getString( "nom" ));
					o.setAdresse(resultat.getString("adresse"));
					o.setTel(resultat.getString("tel"));
					o.setEmail(resultat.getString("email"));
					o.setLogo(resultat.getString("logo"));
					list.add(o);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public Coordonnees getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM coordonnees WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Coordonnees u = new Coordonnees();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setAdresse(resultat.getString("adresse"));
					u.setTel(resultat.getString("tel"));
					u.setEmail(resultat.getString("email"));
					u.setLogo(resultat.getString("logo"));
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	

}
