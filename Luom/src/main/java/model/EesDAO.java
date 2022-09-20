package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EesDAO {
	public void save(Ees obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE ees set id_produit=?,id_fournisseur=?,datee=?,qte=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setInt(2,obj.getId_fournisseur());
				preparedStatement.setDate(3,obj.getDatee());
				preparedStatement.setInt(4,obj.getQte());
				preparedStatement.setInt(5,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO ees (id_produit,id_fournisseur,datee,qte) VALUES(?,?,?,?)");
				preparedStatement.setInt(1,obj.getId_produit());
				preparedStatement.setInt(2,obj.getId_fournisseur());
				preparedStatement.setDate(3,obj.getDatee());
				preparedStatement.setInt(4,obj.getQte());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Ees getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM ees WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Ees u = new Ees();

			u.setId(resultat.getInt( "id" ));
			u.setId_produit(resultat.getInt( "id_produit" ));
			u.setId_fournisseur(resultat.getInt( "id_fournisseur" ));
			u.setDatee(resultat.getDate( "datee" ));
			u.setQte(resultat.getInt( "qte" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ArrayList<Ees> getAllHidden() {
		ArrayList<Ees> list = new ArrayList<Ees>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM ees WHERE del=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Ees o = new Ees();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setId_fournisseur(resultat.getInt( "id_fournisseur" ));
				o.setDatee(resultat.getDate( "datee" ));
				o.setQte(resultat.getInt( "qte" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Ees> getAll() {
		ArrayList<Ees> list = new ArrayList<Ees>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM ees WHERE del=0");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Ees o = new Ees();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setId_fournisseur(resultat.getInt( "id_fournisseur" ));
				o.setDatee(resultat.getDate( "datee" ));
				o.setQte(resultat.getInt( "qte" ));
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

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE ees set del=1 WHERE id=?");
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
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM ees WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	public ArrayList<Ees> HByIdArPr(int id) {
		ArrayList<Ees> list = new ArrayList<Ees>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM ees WHERE id_produit=? AND del=1");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				
				Ees o = new Ees();
				o.setId(resultat.getInt( "id" ));
				
				list.add(o);
			}

			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
			return null;
		}
		
	}
	
	public ArrayList<Ees> getAllAdbyP(int i) {
		ArrayList<Ees> list = new ArrayList<Ees>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM ees WHERE id_produit=? ORDER BY id DESC");
			preparedStatement.setInt(1,i);
			
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Ees o = new Ees();
				o.setId(resultat.getInt( "id" ));
				o.setId_produit(resultat.getInt( "id_produit" ));
				o.setId_fournisseur(resultat.getInt( "id_fournisseur" ));
				o.setDatee(resultat.getDate( "datee" ));
				o.setQte(resultat.getInt( "qte" ));
				o.setDel(resultat.getBoolean( "del" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
