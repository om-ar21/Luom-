package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CommandeDAO {

	public int save(Commande obj) {
		int newid=0;
		try {
			
			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE cmd set id_user=?, id_adresse=?, datec=?, total=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setInt(2,obj.getId_adresse());
				preparedStatement.setDate(3,obj.getDatec());
				preparedStatement.setDouble(4,obj.getTotal());
				
				preparedStatement.setInt(5,obj.getId());
	            preparedStatement.executeUpdate();
	            newid=obj.getId();
	            
	            
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO cmd (id_user,datec,total) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1,obj.getId_user());
				preparedStatement.setDate(2,obj.getDatec());
				preparedStatement.setDouble(3,obj.getTotal());
	            preparedStatement.executeUpdate();
	            
	            ResultSet resultat = preparedStatement.getGeneratedKeys();
	            resultat.next();
	            newid= resultat.getInt(1) ;
	            
	            
	            return newid;
			}
			System.out.println("SAVED OK");
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
		return newid;
	
}
	public Commande getById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cmd WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Commande u = new Commande();
				resultat.next();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_adresse(resultat.getInt( "id_adresse" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getBoolean( "etat" ));
					u.setDel(resultat.getBoolean( "del" ));
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllById(int userid) {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cmd WHERE id_user=? AND del != 2 ORDER BY id DESC");
				preparedStatement.setInt(1,userid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande ();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_adresse(resultat.getInt( "id_adresse" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getBoolean( "etat" ));
					u.setDel(resultat.getBoolean( "del" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAllByPB() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cmd WHERE del = 2 ORDER BY id DESC");
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande ();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_adresse(resultat.getInt( "id_adresse" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getBoolean( "etat" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Commande> getAll() {
		ArrayList<Commande> list = new ArrayList<Commande>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM cmd");
				
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Commande u = new Commande();
					u.setId(resultat.getInt( "id" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_adresse(resultat.getInt( "id_adresse" ));
					u.setTotal(resultat.getDouble( "total" ));
					u.setDatec(resultat.getDate( "datec" ));
					u.setEtat(resultat.getBoolean( "etat" ));
					u.setDel(resultat.getBoolean( "del" ));
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
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE cmd set del=1 WHERE id=?");
				preparedStatement.setInt(1,id);
				
				preparedStatement.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	System.out.println("DELETED NO");
	    }
	}
	
	public void StById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE cmd set del=2 WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("HIDE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
