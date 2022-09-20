package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdresseDAO {
	public void save(Adresse obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE adr_livraison set id_user=?,adresse=?,cp=?,ville=?,pays=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setString(2,obj.getAdresse());
				preparedStatement.setString(3,obj.getCp());
				preparedStatement.setString(4,obj.getVille());
				preparedStatement.setString(5,obj.getPays());
				preparedStatement.setInt(6,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO adr_livraison (id_user,adresse,cp,ville,pays) VALUES(?,?,?,?,?)");
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setString(2,obj.getAdresse());
				preparedStatement.setString(3,obj.getCp());
				preparedStatement.setString(4,obj.getVille());
				preparedStatement.setString(5,obj.getPays());
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Adresse getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM adr_livraison WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Adresse u = new Adresse();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setAdresse(resultat.getString( "adresse" ));
					u.setCp(resultat.getString( "cp" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPays(resultat.getString( "pays" ));
					
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public ArrayList<Adresse> getAllByUserId(int userid) {
		ArrayList<Adresse> list = new ArrayList<Adresse>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM adr_livraison WHERE id_user=? AND del=0");
				preparedStatement.setInt(1,userid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Adresse u = new Adresse();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setAdresse(resultat.getString( "adresse" ));
					u.setCp(resultat.getString( "cp" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPays(resultat.getString( "pays" ));
					
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public void deleteById(int id) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE adr_livraison SET del=1 WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}

}
