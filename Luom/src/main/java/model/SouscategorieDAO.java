package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SouscategorieDAO {

	public void save(Souscategorie obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE s_cat set titre=?,id_cat=? WHERE id=?");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setInt(2,obj.getId());
				preparedStatement.setInt(3,obj.getId_cat());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO s_cat (titre,id_cat) VALUES(?,?)");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setInt(2,obj.getId_cat());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	
	public Souscategorie getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM s_cat WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Souscategorie u = new Souscategorie();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setTitre(resultat.getString( "titre" ));
					u.setId_cat(resultat.getInt( "id_cat" ));
					u.setDel(resultat.getBoolean( "del" ));
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public ArrayList<Souscategorie> getAllById(int idcat) {
		ArrayList<Souscategorie> list = new ArrayList<Souscategorie>();
		CategorieDAO p = new CategorieDAO();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM s_cat WHERE id_cat=? AND del=0");
				preparedStatement.setInt(1,idcat);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Souscategorie u = new Souscategorie ();
					u.setId(resultat.getInt( "id" ));
					u.setId_cat(resultat.getInt( "id_cat" ));
					u.setTitre(resultat.getString("titre"));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public ArrayList<Souscategorie> getAll() {
		CategorieDAO p = new CategorieDAO();
		ArrayList<Souscategorie> list = new ArrayList<Souscategorie>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM s_cat");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Souscategorie u = new Souscategorie();
					u.setId(resultat.getInt( "id" ));
					u.setId_cat(resultat.getInt( "id_cat" ));
					u.setTitre(resultat.getString("titre"));
					
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
}
