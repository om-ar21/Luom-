package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategorieDAO {

public void save(Categorie obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE cat set titre=? WHERE id=?");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setInt(2,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO cat (titre) VALUES(?,?)");
				preparedStatement.setString(1,obj.getTitre());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}

public Categorie getById(int id) {
	
	try {
	
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cat WHERE id=?");
			preparedStatement.setInt(1,id);
			
			ResultSet resultat=preparedStatement.executeQuery();
			
			Categorie u = new Categorie();
			while(resultat.next()) {
				u.setId(resultat.getInt( "id" ));
				u.setTitre(resultat.getString( "titre" ));
				u.setDel(resultat.getBoolean( "del" ));
				
			}
			return u;
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	return null;
    }
}
public ArrayList<Categorie> getAll() {
	ArrayList<Categorie> list = new ArrayList<Categorie>();
	
	try {
		
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cat WHERE del=0");
			
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Categorie o = new Categorie();
				o.setId(resultat.getInt( "id" ));
				o.setTitre(resultat.getString( "titre" ));
				
				list.add(o);
			}
			
			
			return list;
		
	} catch (Exception ex) {
    	ex.printStackTrace();
    	return null;
    }
}



	
}
