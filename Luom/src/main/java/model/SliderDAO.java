package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SliderDAO {
	public void save(Slider obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE slides set titre=?,img=?,lien=? WHERE id=?");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setString(2,obj.getImg());
				preparedStatement.setString(3,obj.getLien());
				preparedStatement.setInt(4,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO slides (titre,img,lien) VALUES(?,?,?)");
				preparedStatement.setString(1,obj.getTitre());
				preparedStatement.setString(2,obj.getImg());
				preparedStatement.setString(3,obj.getLien());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Slider getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM slides WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Slider u = new Slider();

			u.setId(resultat.getInt( "id" ));
			u.setTitre(resultat.getString( "titre" ));
			u.setImg(resultat.getString( "img" ));
			u.setLien(resultat.getString( "lien" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ArrayList<Slider> getAllHidden() {
		ArrayList<Slider> list = new ArrayList<Slider>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM slides WHERE del=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Slider o = new Slider();
				o.setId(resultat.getInt( "id" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setImg(resultat.getString( "img" ));
				o.setLien(resultat.getString( "lien" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Slider> getAll() {
		ArrayList<Slider> list = new ArrayList<Slider>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM slides WHERE del=0");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Slider o = new Slider();
				o.setId(resultat.getInt( "id" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setImg(resultat.getString( "img" ));
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

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE slides set del=1 WHERE id=?");
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
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM slides WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}

}
