package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ImageDAO {
	public void save(Image obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE img set id_produit=?,lien=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setString(2,obj.getLien());
				preparedStatement.setInt(3,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO img (id_produit,lien) VALUES(?,?)");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setString(2,obj.getLien());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Image getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM img WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Image u = new Image();

			u.setId(resultat.getInt( "id" ));
			u.setId_produit(resultat.getInt( "id_produit" ));
			u.setLien(resultat.getString( "lien" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Image> getByIdprod(int id) {
		ArrayList<Image> list = new ArrayList<Image>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM img WHERE id_produit=? AND del=0");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Image o = new Image();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setLien(resultat.getString( "lien" ));
				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ArrayList<Image> getAllHidden() {
		ArrayList<Image> list = new ArrayList<Image>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM img WHERE del=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Image o = new Image();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setLien(resultat.getString( "lien" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Image> getAll() {
		ArrayList<Image> list = new ArrayList<Image>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM img WHERE del=0");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Image o = new Image();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setLien(resultat.getString( "lien" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public void hideById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE img set del=1 WHERE id=?");
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
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM img WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

}
