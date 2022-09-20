package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

	public void save(User obj) {
		
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE user set nom=?,prenom=?,email=?,mdp=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getPrenom());
				preparedStatement.setString(3,obj.getEmail());
				preparedStatement.setString(4,obj.getMdp());
				preparedStatement.setInt(5,obj.getId());
	            preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO user (nom,prenom,inscription,email,mdp) VALUES(?,?,?,?,?)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getPrenom());
				preparedStatement.setDate(3,obj.getInscription());
				preparedStatement.setString(4,obj.getEmail());
				preparedStatement.setString(5,obj.getMdp());
			
	            preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	
	public User getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM user WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				User u = new User();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));	
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString("prenom"));
					u.setInscription(resultat.getDate("inscription"));
					u.setEmail(resultat.getString( "email" ));
					u.setMdp(resultat.getString( "mdp" ));
					
				}
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	

	public User connexion(String email,String mdp) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.
						prepareStatement("SELECT * FROM user WHERE email=? AND mdp=?");
				preparedStatement.setString(1,email);
				preparedStatement.setString(2,mdp);
				ResultSet resultat=preparedStatement.executeQuery();
				User u = new User();
				if(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setInscription(resultat.getDate("inscription"));
					u.setEmail(resultat.getString( "email" ));
					u.setMdp(resultat.getString( "mdp" ));
					u.setDel(resultat.getBoolean( "del" ));
					
					return u;
				}else {
					return null;
				}
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<User> getAll() {
		ArrayList<User> list = new ArrayList<User>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM user");
				
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					User u = new User();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setInscription(resultat.getDate("inscription"));
					u.setEmail(resultat.getString( "email" ));
					u.setMdp(resultat.getString( "mdp" ));
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
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE user SET del=1 WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	
	public void DelById(int id) {
		try {
		            PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE cmd set id_user=1 WHERE id_user=?");
		            preparedStatement.setInt(1,id);
		           
		            preparedStatement.executeUpdate();

		            PreparedStatement preparedStatement2  = Database.connexion.prepareStatement("UPDATE commentaire set id_user=1 WHERE id_user=?");
		            preparedStatement2.setInt(1,id);
		           
		            preparedStatement2.executeUpdate();
		            
		            PreparedStatement preparedStatement3  = Database.connexion.prepareStatement("UPDATE visite set id_user=1 WHERE id_user=?");
		            preparedStatement3.setInt(1,id);
		           
		            preparedStatement3.executeUpdate();
		            
		            PreparedStatement preparedStatement4  = Database.connexion.prepareStatement("UPDATE recherche set id_user=1 WHERE id_user=?");
		            preparedStatement4.setInt(1,id);
		           
		            preparedStatement4.executeUpdate();
		            
		            PreparedStatement preparedStatement7  = Database.connexion.prepareStatement(" DELETE FROM adr_livraison WHERE id_user=?");
		            preparedStatement7.setInt(1,id);
		           
		            preparedStatement7.executeUpdate();
		            
		            PreparedStatement preparedStatement5  = Database.connexion.prepareStatement(" DELETE FROM user WHERE id=?");
		            preparedStatement5.setInt(1,id);
		           
		            preparedStatement5.executeUpdate();
		           
		            
		            System.out.println("TRUE DELETE OK");

			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	
	
	
}
