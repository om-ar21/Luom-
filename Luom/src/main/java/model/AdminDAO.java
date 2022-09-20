package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminDAO {

	public void save(Admin obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE admins set nom=?,email=?,mdp=?,id_privilege=? WHERE id=?");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMdp());
				preparedStatement.setInt(4,obj.getId_privilege());
				preparedStatement.setInt(5,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO admins (nom,email,mdp,id_privilege) VALUES(?,?,?,?)");
				preparedStatement.setString(1,obj.getNom());
				preparedStatement.setString(2,obj.getEmail());
				preparedStatement.setString(3,obj.getMdp());
				preparedStatement.setInt(4,obj.getId_privilege());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Admin getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM admins WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Admin u = new Admin();

			u.setId(resultat.getInt( "id" ));
			u.setNom(resultat.getString( "nom" ));
			u.setEmail(resultat.getString( "email" ));
			u.setMdp(resultat.getString( "mdp" ));
			u.setId_privilege(resultat.getInt( "id_privilege" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ArrayList<Admin> getAllHidden() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM admins WHERE del=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Admin o = new Admin();
				o.setId(resultat.getInt( "id" ));
				o.setNom(resultat.getString( "nom" ));
				o.setEmail(resultat.getString( "email" ));
				o.setMdp(resultat.getString( "mdp" ));
				o.setId_privilege(resultat.getInt( "id_privilege" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Admin> getAll() {
		ArrayList<Admin> list = new ArrayList<Admin>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM admins WHERE del=0");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Admin o = new Admin();
				o.setId(resultat.getInt( "id" ));
				o.setNom(resultat.getString( "nom" ));
				o.setEmail(resultat.getString( "email" ));
				o.setMdp(resultat.getString( "mdp" ));
				o.setId_privilege(resultat.getInt( "id_privilege" ));
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

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE admins set del=1 WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("HIDE OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	//faire un hide car je ne veux pas qu'il n'y ai pas trace et j'ai juste a la limite a reset autre chose a la place de son nom et prenom.
	//on va dire que c'est mon employé donc j'ai quand même le droit de conserver ses données même si il est a la retraite lol i suppose.
}
