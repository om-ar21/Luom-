package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Categorie;
import model.CategorieDAO;
import model.Database;
import model.Favoris;
import model.FavorisDAO;
import model.Panier;
import model.PanierDetails;
import model.Produit;
import model.ProduitDAO;
import model.Slider;
import model.SliderDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		
		boolean first = false;
		request.setAttribute("first", first);
		
		HttpSession session = request.getSession(true);
		
		SliderDAO sdao = new SliderDAO();
		ArrayList<Slider> slides = sdao.getAll();
		request.setAttribute("slids", slides);
		
		CategorieDAO catdao = new CategorieDAO();
		ArrayList<Categorie> cat= catdao.getAll();
		request.setAttribute("cats", cat);
		
		Categorie cat1= catdao.getById(1);
		request.setAttribute("cat1", cat1);
		
		Categorie cat2= catdao.getById(2);
		request.setAttribute("cat2", cat2);
		
		Categorie cat3= catdao.getById(3);
		request.setAttribute("cat3", cat3);
		
		ProduitDAO pdao = new ProduitDAO();
//		ArrayList<Produit> colprods = pdao.getAll();
//		request.setAttribute("prods", colprods);
		
		boolean load=false;
		if(request.getParameter("padd")!=null) {
			
			load=true;
			int bt = Integer.valueOf(request.getParameter("padd"));
			Produit prod = pdao.getById(bt);
			int qte= 1;
			PanierDetails panieradd=new PanierDetails(prod, qte);
			Panier panier=(Panier) session.getAttribute("panier");
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect("Index");
			
			}
		
		if(request.getParameter("paddqte")!=null) {
			
			load=true;
			int bt = Integer.valueOf(request.getParameter("paddqte"));
			Produit prod = pdao.getById(bt);
			System.out.println(prod);
			int qte=Integer.valueOf(request.getParameter("newqte"));
			Panier panier=(Panier) session.getAttribute("panier");
			if(qte <= 0) {
				qte=0;
				panier.delete(bt);
			}
			PanierDetails panieradd=new PanierDetails(prod, qte);
			panier.ajouter(panieradd);
			session.setAttribute("panier", panier);
			
			response.sendRedirect(request.getHeader("referer"));
			
			}
		
		Favoris fv = new Favoris();
		FavorisDAO favorisdao = new FavorisDAO();
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
		
		/*essai du limit*/
		ArrayList<Produit> colprodslim = pdao.getAllStart();
		request.setAttribute("prods", colprodslim);
		
		if(request.getParameter("voirplus")!=null) {
			first=true;
			int vp = Integer.valueOf(request.getParameter("voirplus"));
			System.out.print(vp);
			ArrayList<Produit> colprodslimvoir = pdao.getAllLimit(vp);
			if(colprodslimvoir.isEmpty()) {
				first=false;
			}
			request.setAttribute("first", first);
			request.setAttribute("voirprods", colprodslimvoir);
		}
		
		if(!load) {
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
