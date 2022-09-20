package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProduitDAO {
	public void save(Produit obj) {

		try {

			if(obj.getId() != 0) {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE produit set id_s_cat=?,titre=?,presentation=?,img=?,prix=?,stock=?,stock_minimum=?,del=? WHERE id=?");
				preparedStatement.setInt(1,obj.getId_s_cat());
				preparedStatement.setString(2,obj.getTitre());
				preparedStatement.setString(3,obj.getPresentation());
				preparedStatement.setString(4,obj.getImg());
				preparedStatement.setDouble(5,obj.getPrix());
				preparedStatement.setInt(6,obj.getStock());
				preparedStatement.setInt(7,obj.getStock_minimum());
				preparedStatement.setBoolean(8, obj.isDel());
				preparedStatement.setInt(9,obj.getId());
				preparedStatement.executeUpdate();
			}else {
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO produit (id_s_cat,titre,presentation,img,prix,stock,stock_minimum,del) VALUES(?,?,?,?,?)");
				preparedStatement.setInt(1,obj.getId_s_cat());
				preparedStatement.setString(2,obj.getTitre());
				preparedStatement.setString(3,obj.getPresentation());
				preparedStatement.setString(4,obj.getImg());
				preparedStatement.setDouble(5,obj.getPrix());
				preparedStatement.setInt(6,obj.getStock());
				preparedStatement.setInt(7,obj.getStock_minimum());
				preparedStatement.setBoolean(8, obj.isDel());
				preparedStatement.executeUpdate();
			}
			System.out.println("SAVED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		}

	}

	public Produit getById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE id=?");
			preparedStatement.setInt(1,id);

			ResultSet resultat=preparedStatement.executeQuery();

			resultat.next();
			Produit u = new Produit();

			u.setId(resultat.getInt( "id" ));
			u.setId_s_cat(resultat.getInt( "id_s_cat" ));
			u.setTitre(resultat.getString( "titre" ));
			u.setPresentation(resultat.getString( "presentation" ));
			u.setImg(resultat.getString( "img" ));
			u.setPrix(resultat.getDouble( "prix" ));
			u.setStock(resultat.getInt( "stock" ));
			u.setStock_minimum(resultat.getInt( "stock_minimum" ));
			u.setDel(resultat.getBoolean( "del" ));

			return u;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


	public ArrayList<Produit> getAllHidden() {
		ArrayList<Produit> list = new ArrayList<Produit>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=1");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Produit o = new Produit();
				o.setId(resultat.getInt( "id" ));
				o.setId_s_cat(resultat.getInt( "id_s_cat" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setPresentation(resultat.getString( "presentation" ));
				o.setImg(resultat.getString( "img" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setStock(resultat.getInt( "stock" ));
				o.setStock_minimum(resultat.getInt( "stock_minimum" ));
				o.setDel(resultat.getBoolean( "del" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Produit> getAll() {
		ArrayList<Produit> list = new ArrayList<Produit>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=0");

			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Produit o = new Produit();
				o.setId(resultat.getInt( "id" ));
				o.setId_s_cat(resultat.getInt( "id_s_cat" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setPresentation(resultat.getString( "presentation" ));
				o.setImg(resultat.getString( "img" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setStock(resultat.getInt( "stock" ));
				o.setStock_minimum(resultat.getInt( "stock_minimum" ));
				o.setDel(resultat.getBoolean( "del" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Produit> getAllByCat(int id_cat) {
		ArrayList<Produit> list = new ArrayList<Produit>();
		
		CategorieDAO cdao = new CategorieDAO();
		Categorie c = cdao.getById(id_cat);
		ArrayList<Souscategorie> sscat = c.ciblesscat();
		for(Souscategorie ssc:sscat) {
			int id_s_cat = ssc.getId();
		
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=0 AND id_s_cat=? ORDER BY id DESC");
			preparedStatement.setInt(1,id_s_cat);
			
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Produit o = new Produit();
				o.setId(resultat.getInt( "id" ));
				o.setId_s_cat(resultat.getInt( "id_s_cat" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setPresentation(resultat.getString( "presentation" ));
				o.setImg(resultat.getString( "img" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setStock(resultat.getInt( "stock" ));
				o.setStock_minimum(resultat.getInt( "stock_minimum" ));
				o.setDel(resultat.getBoolean( "del" ));
				list.add(o);
			}


		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		}
		return list;
	}
	
	public ArrayList<Produit> getAllBySCat(int id_s_cat) {
		ArrayList<Produit> list = new ArrayList<Produit>();
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=0 AND id_s_cat=? ORDER BY id DESC");
			preparedStatement.setInt(1,id_s_cat);
			
			ResultSet resultat=preparedStatement.executeQuery();

			while(resultat.next()) {
				Produit o = new Produit();
				o.setId(resultat.getInt( "id" ));
				o.setId_s_cat(resultat.getInt( "id_s_cat" ));
				o.setTitre(resultat.getString( "titre" ));
				o.setPresentation(resultat.getString( "presentation" ));
				o.setImg(resultat.getString( "img" ));
				o.setPrix(resultat.getDouble( "prix" ));
				o.setStock(resultat.getInt( "stock" ));
				o.setStock_minimum(resultat.getInt( "stock_minimum" ));
				o.setDel(resultat.getBoolean( "del" ));
				list.add(o);
			}


			return list;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Produit> Rechercher(String mot) {
		ArrayList<Produit> list = new ArrayList<Produit>();
		try {
			
				PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE Titre like ? or presentation like ? AND del=0");
				preparedStatement.setString(1,"%"+mot+"%");
				preparedStatement.setString(2,"%"+mot+"%");
				ResultSet resultat=preparedStatement.executeQuery();

				while(resultat.next()) {
					Produit u = new Produit();
					u.setId(resultat.getInt( "id" ));
					u.setTitre(resultat.getString( "titre" ));
					u.setPresentation(resultat.getString( "presentation" ));
					u.setPrix(resultat.getDouble( "prix" ));
					u.setStock(resultat.getInt( "stock" ));
					u.setStock_minimum(resultat.getInt( "stock_minimum" ));
					u.setImg(resultat.getString( "img" ));
					u.setId_s_cat(resultat.getInt( "id_s_cat" ));
					u.setDel(resultat.getBoolean( "del" ));
					
					list.add(u);
				}
				return list;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	
	    }
		return list;
	}
	
	public void hideById(int id) {
		try {

			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE produit set del=1 WHERE id=?");
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
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM produit WHERE id=?");
			preparedStatement.setInt(1,id);
			preparedStatement.executeUpdate();

			System.out.println("DELETED OK");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
	}
	
	public ArrayList<Produit> getAllStart() {
        ArrayList<Produit> list = new ArrayList<Produit>();
        try {

            PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=0 LIMIT 9");
            
            ResultSet resultat=preparedStatement.executeQuery();

            while(resultat.next()) {
                Produit o = new Produit();
                o.setId(resultat.getInt( "id" ));
                o.setId_s_cat(resultat.getInt( "id_s_cat" ));
                o.setTitre(resultat.getString( "titre" ));
                o.setPresentation(resultat.getString( "presentation" ));
                o.setImg(resultat.getString( "img" ));
                o.setPrix(resultat.getDouble( "prix" ));
                o.setStock(resultat.getInt( "stock" ));
                o.setStock_minimum(resultat.getInt( "stock_minimum" ));

                list.add(o);
            }


            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	public ArrayList<Produit> getAllLimit(int derid) {
        ArrayList<Produit> list = new ArrayList<Produit>();
        try {

            PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM produit WHERE del=0 LIMIT ?,9");
            preparedStatement.setInt(1,derid);
            
            ResultSet resultat=preparedStatement.executeQuery();

            while(resultat.next()) {
                Produit o = new Produit();
                o.setId(resultat.getInt( "id" ));
                o.setId_s_cat(resultat.getInt( "id_s_cat" ));
                o.setTitre(resultat.getString( "titre" ));
                o.setPresentation(resultat.getString( "presentation" ));
                o.setImg(resultat.getString( "img" ));
                o.setPrix(resultat.getDouble( "prix" ));
                o.setStock(resultat.getInt( "stock" ));
                o.setStock_minimum(resultat.getInt( "stock_minimum" ));

                list.add(o);
            }


            return list;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
