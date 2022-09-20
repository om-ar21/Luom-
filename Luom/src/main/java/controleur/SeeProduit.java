package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Categorie;
import model.Commentaire;
import model.CommentaireDAO;
import model.Database;
import model.Ees;
import model.EesDAO;
import model.Favoris;
import model.FavorisDAO;
import model.Image;
import model.ImageDAO;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;
import model.Souscategorie;
import model.SouscategorieDAO;
import model.Visite;
import model.VisiteDAO;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Servlet implementation class SeeProduit
 */
public class SeeProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		
		HttpSession session = request.getSession(true);
		boolean load=false;
		boolean pb=false;
		//enregistrement de la visite =
		
		Visite vis = new Visite();
		Date Now = Date.valueOf(LocalDate.now());
		vis.setDatev(Now);
		if(session.getAttribute("userid")!=null) {
			int iduser = (int) session.getAttribute("userid");
			vis.setId_user(iduser);
		}else{
			vis.setId_user(1); //un est defini comme le guest dans ma bd.
		};
		int id= Integer.valueOf(request.getParameter("id"));
		
		ProduitDAO produitdao = new ProduitDAO();
		Produit prod = produitdao.getById(id);
		if(prod.isDel()==true) {
			load=true;
			response.sendRedirect("NotFound");
		}else {
		vis.setId_produit(id);
		VisiteDAO vdao = new VisiteDAO();
		vdao.save(vis);
		
		SouscategorieDAO sscatdao = new SouscategorieDAO();
		CommentaireDAO comdao = new CommentaireDAO();
		ImageDAO imagedao = new ImageDAO();
		
		int idsscat= prod.getId_s_cat();
		
		ArrayList<Produit> sscatcolprods = produitdao.getAllBySCat(idsscat);
		//ça c'est pour les produits similaires 
		Souscategorie sscat = sscatdao.getById(idsscat);
		
		ArrayList<Image> limgs = imagedao.getByIdprod(id);
		
		ArrayList<Commentaire> comprods = comdao.getAllByProds(id);
		int compte = comdao.countAll(comprods);
		System.out.println(compte);
		request.setAttribute("counter", compte);
		
		double aff = comdao.MoyenneAffichage(comprods);
		//des que je peux je dois mettre la note en dbl c'est plus logique.
		request.setAttribute("rateAff", aff);
		//peux pas mettre promo nulle sinon veux pas me modif la note le bougre XD
		
		//demander à zack pk ça veux pas c'est relou en vrai.
		
		request.setAttribute("produit", prod);
		request.setAttribute("catprods", sscatcolprods);
		request.setAttribute("comprods", comprods);
		request.setAttribute("sscate", sscat);
		Categorie c = prod.getCat();
		ArrayList<Produit> prodscat = produitdao.getAllByCat(c.getId());
		request.setAttribute("cate", c);
		request.setAttribute("prodscat", prodscat);
		request.setAttribute("imgs", limgs);
		
		int n = comdao.Moyenne(comprods);
		request.setAttribute("rate", n);
		
		//ADD TO CART.
		if(request.getParameter("padd")!=null) {
			if((Panier) session.getAttribute("panier")==null) {
				Panier panier_temp=new Panier();
				session.setAttribute( "panier", panier_temp );
			}
			load=true;
			int bt = Integer.valueOf(request.getParameter("padd"));
			Produit prodinteret = produitdao.getById(bt);
			int qte= 1;
			PanierDetails panieradd=new PanierDetails(prodinteret, qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
			if(request.getParameter("paddqte")!=null) {
			
			load=true;
			int qte=Integer.valueOf(request.getParameter("newqte"));
			Panier panier=(Panier) session.getAttribute("panier");
			if(qte <= 0) {
				qte=0;
			}
			PanierDetails panieradd=new PanierDetails(prod, qte);
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
		if(session.getAttribute("userid")!=null) {
			int idus = (int) session.getAttribute("userid");
			Commentaire mycom = comdao.getByIDclientAndIdproduit(idus, id);
			request.setAttribute("mycom", mycom);
		}
		
		if(request.getParameter("comment")!=null) {
			//si je capte un appui sur mon bouton alors
			//je recup le truc qui contient note;
			
			int note=0;
			if(request.getParameter("note")==null) {
				note=0;
			}else{
				try {
					note=Integer.valueOf(request.getParameter("note")); 
		            // if var is not a number than this statement throw Exception
		            // and Catch Block will Run
		            System.out.println("Number");
		            
		            if(note<0) {
						note=0;
					}
					
					if(note>5) {
						note=5;
					}
					
					String cont="";
					if(request.getParameter("message")==null) {
						cont="";
					}else{
						
					cont=request.getParameter("message");}
					
					Commentaire cmt = new Commentaire();
					
					Date timeNow = Date.valueOf(LocalDate.now());
					
					if(session.getAttribute("userid")==null) {
						load=true;
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
					}else {
					int iduser = (int) session.getAttribute("userid");
					cmt.setDay(timeNow);
					cmt.setNote(note);
					cmt.setContenu(cont);
					cmt.setId_produit(id);
					cmt.setId_user(iduser);
					cmt.setDel(false);
					
					Commentaire cmtexist = comdao.getByIDclientAndIdproduit(iduser, id);
					if(cmtexist==null) {
						load=true;
						comdao.save(cmt);
						session.removeAttribute("fail");
						session.setAttribute("reu", load);
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
					}else {
						load=true;
						cmt.setId(cmtexist.getId());
						comdao.save(cmt);
						session.removeAttribute("fail");
						session.setAttribute("reu", load);
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
						//me permet d'afficher le message vous avez déjà commenté, pour modifier votre commentaire allez sur mon commentaire.
					}
					
					}
		            
		        } catch (NumberFormatException ex) { 
		            System.out.println(" Not A Number");
		            load=true;
		            session.removeAttribute("reu");
		            pb=true;
		            session.setAttribute("fail", pb);
		            if (request instanceof HttpServletRequest) {
		   			 String url = ((HttpServletRequest)request).getRequestURL().toString();
		   			 String queryString = ((HttpServletRequest)request).getQueryString();
		   			 System.out.println(url + "?" + queryString); 
		   			 response.sendRedirect(url + "?" + queryString);
		   		}
		            
		        }
			}
			
		}
		
		if(request.getParameter("modif")!=null) {
			//si je capte un appui sur mon bouton alors
			//je recup le truc qui contient note;
			
			int note=0;
			if(request.getParameter("note")==null) {
				note=0;
			}else{
				try {
					note=Integer.valueOf(request.getParameter("note")); 
		            // if var is not a number than this statement throw Exception
		            // and Catch Block will Run
		            System.out.println("Number");
		            
		            if(note<0) {
						note=0;
					}
					
					if(note>5) {
						note=5;
					}
					
					String cont="";
					if(request.getParameter("message")==null) {
						cont="";
					}else{
						
					cont=request.getParameter("message");}
					
					Commentaire cmt = new Commentaire();
					
					Date timeNow = Date.valueOf(LocalDate.now());
					
					if(session.getAttribute("userid")==null) {
						load=true;
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
					}else {
					int iduser = (int) session.getAttribute("userid");
					cmt.setDay(timeNow);
					cmt.setNote(note);
					cmt.setContenu(cont);
					cmt.setId_produit(id);
					cmt.setId_user(iduser);
					
					Commentaire cmtexist = comdao.getByIDclientAndIdproduit(iduser, id);
					if(cmtexist==null) {
						load=true;
						comdao.save(cmt);
						session.removeAttribute("fail");
						session.setAttribute("reu", load);
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
					}else {
						load=true;
						cmt.setId(cmtexist.getId());
						comdao.save(cmt);
						session.removeAttribute("fail");
						session.setAttribute("reu", load);
						if (request instanceof HttpServletRequest) {
							 String url = ((HttpServletRequest)request).getRequestURL().toString();
							 String queryString = ((HttpServletRequest)request).getQueryString();
							 System.out.println(url + "?" + queryString); 
							 response.sendRedirect(url + "?" + queryString);
						}
						//me permet d'afficher le message vous avez déjà commenté, pour modifier votre commentaire allez sur mon commentaire.
					}
					
					
					}
		            
		        } catch (NumberFormatException ex) { 
		            System.out.println(" Not A Number");
		            load=true;
		            session.removeAttribute("reu");
		            pb=true;
		            session.setAttribute("fail", pb);
		            if (request instanceof HttpServletRequest) {
		   			 String url = ((HttpServletRequest)request).getRequestURL().toString();
		   			 String queryString = ((HttpServletRequest)request).getQueryString();
		   			 System.out.println(url + "?" + queryString); 
		   			 response.sendRedirect(url + "?" + queryString);
		   		}
		            
		        }
			}
			
		}
		
		Favoris fv = new Favoris();
		FavorisDAO favorisdao = new FavorisDAO();
		
		//voir si les pb ne vient pas des mêmes boutons.
		if(request.getParameter("btnadd")!=null) {
			load=true;
			
			int idp = Integer.valueOf(request.getParameter("idp"));
			System.out.println(idp);
			int userid=(int)session.getAttribute("userid");
			fv.setId_produit(idp);
			fv.setId_user(userid);
			favorisdao.save(fv);
			fv=favorisdao.getById(userid);
			
			request.setAttribute("userid", userid);
			request.setAttribute("userid", userid);
			
			response.sendRedirect(request.getHeader("referer"));
		
		}
		if(request.getParameter("btnrmv")!=null) {
			load=true;
			int idp = Integer.valueOf(request.getParameter("idp"));
			int userid=(int)session.getAttribute("userid");
			favorisdao.hideById(idp, userid);
			response.sendRedirect(request.getHeader("referer"));
		}
		
		EesDAO ed = new EesDAO();
		
		ArrayList<Ees> e = ed.getAllAdbyP(id);
		int qcom = 0;
		for(Ees ees:e){ 
			if(ees.isDel()==true) {
			qcom+= 0;
			}else {
			qcom+= ees.getQte();
			}
		}
		request.setAttribute("qcom", qcom);
		
		
		if(request.getParameter("yes")!=null) {
			load=true;
			int iduser = (int) session.getAttribute("userid");
			Commentaire cmtexist = comdao.getByIDclientAndIdproduit(iduser, id);
			if(cmtexist!=null) {
			comdao.deleteById(cmtexist.getId());
			}else {
			System.out.print("pb");
			}
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(request.getParameter("non")!=null) {
			load=true;
			response.sendRedirect(request.getHeader("referer"));
		}
		
		if(!load) {
		request.getRequestDispatcher("seeProduit.jsp").forward(request, response);
		}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
