package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RechercheDAO {
	public void save(Recherche obj) {
		
		try {
			
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO recherche (id_user,mot,rech) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setString(2,obj.getMot());
				preparedStatement.setDate(3,obj.getRech());
	            preparedStatement.executeUpdate();
	            
	            ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            System.out.println("insert ok");
	            
	            
			
			System.out.println("save ok");
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	
	public Recherche getById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM recherche WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Recherche u = new Recherche();
				resultat.next();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setMot(resultat.getString("mot"));
					u.setRech(resultat.getDate( "rech" ));
					
				
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public ArrayList<Recherche> getAll() {
		ArrayList<Recherche> list = new ArrayList<Recherche>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM recherche");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Recherche u = new Recherche();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setMot(resultat.getString("mot"));
					u.setRech(resultat.getDate( "rech" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}

}
