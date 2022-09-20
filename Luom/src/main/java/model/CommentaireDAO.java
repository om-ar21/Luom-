package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentaireDAO {
	public void save(Commentaire obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaire set id_produit=?,id_user=?,contenu=?,note=?,day=?,del=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setInt(2,obj.getId_user());
				preparedStatement.setString(3,obj.getContenu());
				preparedStatement.setInt(4,obj.getNote());
				preparedStatement.setDate(5,obj.getDay());
				preparedStatement.setBoolean(6,obj.isDel());
				preparedStatement.setInt(7,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO commentaire (id_produit,id_user,contenu,note,day,del) VALUES(?,?,?,?,?,?)");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setInt(2,obj.getId_user());
				preparedStatement.setString(3,obj.getContenu());
				preparedStatement.setInt(4,obj.getNote());
				preparedStatement.setDate(5,obj.getDay());
				preparedStatement.setBoolean(6,obj.isDel());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Commentaire getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Commentaire u = new Commentaire();

			u.setId(resultat.getInt( "id" ));
			u.setDay(resultat.getDate( "day" ));
			u.setId_produit(resultat.getInt( "id_produit" ));
			u.setId_user(resultat.getInt( "id_user" ));
			u.setContenu(resultat.getString( "contenu" ));
			u.setNote(resultat.getInt( "note" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Commentaire> getAll() {
		ArrayList<Commentaire> list = new ArrayList<Commentaire>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE del=0 ORDER BY day DESC");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Commentaire o = new Commentaire();
				o.setId(resultat.getInt( "id" ));
				o.setDay(resultat.getDate( "day" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setId_user(resultat.getInt( "id_user" ));
				o.setContenu(resultat.getString( "contenu" ));
				o.setNote(resultat.getInt( "note" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Commentaire> getAllByProds(int prid) {
		ArrayList<Commentaire> list = new ArrayList<Commentaire>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id_produit=? AND del=0 ORDER BY day DESC");
				preparedStatement.setInt(1,prid);
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Commentaire u = new Commentaire();
					u.setId(resultat.getInt( "id" ));
					u.setDay(resultat.getDate( "day" ));
					u.setId_produit(resultat.getInt( "id_produit" ));
					u.setId_user(resultat.getInt( "id_user" ));
					u.setContenu(resultat.getString( "contenu" ));
					u.setNote(resultat.getInt( "note" ));
					list.add(u);
				}
				
				
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public int countAll(ArrayList<Commentaire> coms) {
		
		ArrayList<Commentaire> com = coms;
		int counter = 0;
		for(Commentaire c:com){
			counter++;
		}
		
		return counter;

	}
	
	public double MoyenneAffichage(ArrayList<Commentaire> coms) {
		//sur le principe ça ressemble beaucoup a ajouter mais du coup je vais prendre les quantités de 
		//chaque articles normalement ça devrait compter chaque produits.
		
		ArrayList<Commentaire> com = coms;
		int note = 0;
		for(Commentaire c:com){
			int dep = c.getNote();
			note+=dep;
		}
		
		CommentaireDAO comd = new CommentaireDAO();
		int c = comd.countAll(coms);
		double moy = (double)note/c;
		
		System.out.println(moy);
		
		
		return moy; 
		//arrondi a l'inferieur donc relou moi je ne veux pas mdrrr

	}
	
	public Commentaire getByIDclientAndIdproduit(int clid,int prid) {
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id_user=? AND id_produit=?");
				preparedStatement.setInt(1,clid);
				preparedStatement.setInt(2,prid);
				ResultSet resultat=preparedStatement.executeQuery();

				resultat.next();
				Commentaire u = new Commentaire();

				u.setId(resultat.getInt( "id" ));
				u.setDay(resultat.getDate( "day" ));
				u.setId_produit(resultat.getInt( "id_produit" ));
				u.setId_user(resultat.getInt( "id_user" ));
				u.setContenu(resultat.getString( "contenu" ));
				u.setNote(resultat.getInt( "note" ));
				
				return u;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	
	public void hideById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE commentaire set del=1 WHERE id=?");
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
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM commentaire WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

	public int Moyenne(ArrayList<Commentaire> coms) {
		// TODO Auto-generated method stub
		ArrayList<Commentaire> com = coms;
		int note = 0;
		for(Commentaire c:com){
			int dep = c.getNote();
			note+=dep;
		}
		
		CommentaireDAO comd = new CommentaireDAO();
		int c = comd.countAll(coms);
		double moy = (double)note/c;
		
		System.out.println(Math.round( moy ));
		System.out.println(moy);
		//int roundedNumA = (int)Math.ceil(moy);
		int roundedNumA = (int)Math.round( moy );
		
		System.out.printf( "Math.round( %.1f ) == %d\n", moy, Math.round( moy ) );
		
		return roundedNumA; 
	}
	
}
