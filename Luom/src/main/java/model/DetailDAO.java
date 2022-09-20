package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailDAO {
	public void save(Detail obj) {
		
				try {
					
					if(obj.getId() != 0) {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE detail_cmd set id_cmd=?,id_produit=?,qte=?,prix=? WHERE id=?");
						preparedStatement.setInt(1,obj.getId_commandes());
						preparedStatement.setInt(2,obj.getId_produits());
						preparedStatement.setInt(3,obj.getQte());
						preparedStatement.setDouble(4,obj.getPrix());
						preparedStatement.setInt(5,obj.getId());
			            preparedStatement.executeUpdate();
					}else {
						PreparedStatement preparedStatement  = Database.connexion.prepareStatement("INSERT INTO detail_cmd (id_cmd,id_produit,qte,prix) VALUES(?,?,?,?)");
						preparedStatement.setInt(1,obj.getId_commandes());
						preparedStatement.setInt(2,obj.getId_produits());
						preparedStatement.setInt(3,obj.getQte());
						preparedStatement.setDouble(4,obj.getPrix());
			            preparedStatement.executeUpdate();
					}
					System.out.println("SAVED OK");
					
				} catch (Exception ex) {
		        	ex.printStackTrace();
		        	System.out.println("SAVED NO");
		        }
			
		}
		
		public Detail getById(int id) {
			try {
			
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM detail_cmd WHERE id=?");
					preparedStatement.setInt(1,id);
					
					ResultSet resultat=preparedStatement.executeQuery();
					
					resultat.next();
					Detail u = new Detail();
					
						u.setId(resultat.getInt( "id" ));
						u.setId_commandes(resultat.getInt( "id_cmd" ));
						u.setId_produits(resultat.getInt( "id_produit" ));
						u.setQte(resultat.getInt( "qte" ));
						u.setPrix(resultat.getDouble( "prix" ));
						u.setDel(resultat.getBoolean( "del" ));
					
					return u;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		public ArrayList<Produit> getAllByCom(int Com) {
			ArrayList<Produit> list = new ArrayList<Produit>();
			//je veux des produits en sortie donc je viens chercher une liste.
			
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT id_produit FROM detail_cmd WHERE id_cmd=?");
					preparedStatement.setInt(1,Com);
					
					ResultSet resultat=preparedStatement.executeQuery();

					ProduitDAO udao = new ProduitDAO();
					while(resultat.next()) {
						
						Detail x = new Detail();
						
						x.setId_produits(resultat.getInt( "id_produit" ));
						
						Produit u = udao.getById(x.getId_produits());//yay donc j'ai mon arraylist de produits par détails.
					
						list.add(u);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		
		public ArrayList<Detail> getAllByCommande(int commandeid) {
			ArrayList<Detail> list = new ArrayList<Detail>();
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM detail_cmd WHERE Id_cmd=?");
					preparedStatement.setInt(1,commandeid);
					ResultSet resultat=preparedStatement.executeQuery();
		
					while(resultat.next()) {
						Detail u = new Detail();
						u.setId(resultat.getInt( "id" ));
						u.setId_commandes(resultat.getInt( "id_cmd" ));
						u.setId_produits(resultat.getInt( "id_produit" ));
						u.setQte(resultat.getInt( "qte" ));
						u.setPrix(resultat.getDouble( "prix" ));
						u.setDel(resultat.getBoolean( "del" ));
						list.add(u);
					}
					
					
					return list;
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	return null;
		    }
		}
		
		/*en theorie on ne le fera jamais le sauter le detail car la commande est amenée à rester en base*/
		public void deleteById(int id) {
			try {
				
					PreparedStatement preparedStatement  = Database.connexion.prepareStatement("DELETE FROM detail_cmd WHERE id=?");
					preparedStatement.setInt(1,id);
					
					preparedStatement.executeUpdate();
					
					System.out.println("DELETED OK");
				
			} catch (Exception ex) {
		    	ex.printStackTrace();
		    	System.out.println("DELETED NO");
		    }
		}

		//faire le hide by id.
		public void hideById(int id) {
            try {

                    PreparedStatement preparedStatement  = Database.connexion.prepareStatement("UPDATE detail_cmd set del=1 WHERE id=?");
                    preparedStatement.setInt(1,id);

                    preparedStatement.executeUpdate();

                    System.out.println("DELETED OK");

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("DELETED NO");
            }
        }
}
