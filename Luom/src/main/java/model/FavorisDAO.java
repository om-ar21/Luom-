package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FavorisDAO {
	
	public void save(Favoris obj) {
		
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO favoris (id_produit,id_user) VALUES(?,?)");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setInt(2,obj.getId_user());
	            preparedStatement.executeUpdate();
			
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	

	public Favoris getById(int id) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM favoris WHERE id=?");
				preparedStatement.setInt(1,id);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Favoris u = new Favoris();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setId_produit(resultat.getInt( "id_produit" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setFav(resultat.getInt( "fav" ));
					
					
					
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	public Favoris getByIdProduit(int idproduit) {
		try {
		
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM favoris WHERE id_produit=?");
				preparedStatement.setInt(1,idproduit);
				
				ResultSet resultat=preparedStatement.executeQuery();
				
				Favoris u = new Favoris();
				while(resultat.next()) {
					u.setId(resultat.getInt( "id" ));
					u.setId_produit(resultat.getInt( "id_produit" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setFav(resultat.getInt( "fav" ));
					
					
					
				}
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Favoris> getAllById(int userid) {
		ArrayList<Favoris> list = new ArrayList<Favoris>();
	
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM favoris WHERE id_user=? AND fav=1");
				preparedStatement.setInt(1,userid);
				ResultSet resultat=preparedStatement.executeQuery();
	
				while(resultat.next()) {
					Favoris u = new Favoris ();
					u.setId(resultat.getInt( "id" )); 
					u.setId_user(resultat.getInt( "id_user" ));
					u.setId_produit(resultat.getInt("id_produit"));
					u.setFav(resultat.getInt( "fav" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public ArrayList<Favoris> getAll() {
		ArrayList<Favoris> list = new ArrayList<Favoris>();
		UserDAO u = new UserDAO();
	
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM  favoris");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Favoris o = new Favoris();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setId_user(resultat.getInt( "id_user" ));
				
				o.setFav(resultat.getInt( "fav" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public int getCountFavorisByID(int id) {
        try {

                PreparedStatement preparedStatement  = Database.connexion.
        prepareStatement("SELECT COUNT(*)as total FROM favoris WHERE id_user=? AND fav=1");
                preparedStatement.setInt(1,id);

                ResultSet resultat=preparedStatement.executeQuery();
                resultat.next();

                int total = resultat.getInt( "total" );
                return total;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
	
	public void hideById(int idproduit, int iduser ) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE favoris set fav=0 WHERE id_produit=? AND id_user=?");
			preparedStatement.setInt(1,idproduit);
			preparedStatement.setInt(2,iduser);
			preparedStatement.executeUpdate();

			System.out.println("HIDE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	public void hideByIdFav(int id ) {
        try {

            PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE favoris set fav=0 WHERE id=?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

            System.out.println("HIDE OK");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("DELETED NO");
        }
    }
	
	public void deleteById(int id) {
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM favoris WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
}
