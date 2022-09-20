package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Adresse;
import model.AdresseDAO;
import model.Database;

import java.io.IOException;

/**
 * Servlet implementation class Modifieradr
 */
public class Modifieradr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifieradr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		HttpSession session = request.getSession( true );
		boolean load=false;
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Notconnected"); 
		}else {
			AdresseDAO adressedao = new AdresseDAO();
			//pour recupererer l id de l adresse
			int id = Integer.valueOf(request.getParameter("idadr"));
			request.setAttribute("idamodif", id);
			System.out.println(id);
			Adresse ad = adressedao.getById(id);
			//Si le boutton mettre à jour est cliqué
			if (request.getParameter("btnadr")!=null) {
				int idamodif=Integer.valueOf(request.getParameter("btnadr"));
				load=true;
				String adresse =request.getParameter("adresse");
				String cp= request.getParameter("cp");
				String ville = request.getParameter("ville");
				String pays = request.getParameter("pays");
			    
				ad.setId(idamodif);
				ad.setAdresse(adresse);
				ad.setCp(cp);
				ad.setVille(ville);
				ad.setPays(pays);
				
				
				adressedao.save(ad);
				response.sendRedirect("Moncompte");
				
			}
			request.setAttribute("ad", ad);
		}
		
		if(!load) {
			request.getRequestDispatcher( "modifadr.jsp" ).forward( request, response );
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
