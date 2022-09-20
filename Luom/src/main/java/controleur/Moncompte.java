package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Adresse;
import model.AdresseDAO;
import model.Commande;
import model.CommandeDAO;
import model.Database;
import model.User;
import model.UserDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Moncompte
 */
public class Moncompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Moncompte() {
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
			System.out.print(session.getAttribute("userid"));
			UserDAO userdao = new UserDAO();
			//pour recupererer l id de l utilisateur 
			int UtilisateurId = (int)session.getAttribute("userid");
			CommandeDAO cdao = new CommandeDAO();
			ArrayList<Commande> c = cdao.getAllById(UtilisateurId);
			User us = userdao.getById(UtilisateurId);
			boolean messagemodifok = false;
			boolean adressevide=false;
			boolean cvide=false;
			AdresseDAO adressdao = new AdresseDAO();
			ArrayList<Adresse> adresse = adressdao.getAllByUserId(UtilisateurId);
			if(adresse.isEmpty()) {
				adressevide=true;
			}
			if(c.isEmpty()) {
				cvide=true;
			}
			
			if(request.getParameter("btnsupp")!=null) {
                load=true;

                userdao.DelById(UtilisateurId);
                response.sendRedirect("Deconnexion");
            }
			
			if(request.getParameter("delete")!=null) {
				int id = Integer.valueOf(request.getParameter("delete"));
				adressdao.deleteById(id);
				load =true;
				response.sendRedirect("Moncompte");
			}
			
			request.setAttribute("adresse", adresse);
			request.setAttribute("adressevide", adressevide);
			request.setAttribute("us", us);
			request.setAttribute("messagemodifok", messagemodifok);
			request.setAttribute("cvide", cvide);
			request.setAttribute("comm", c);
			if(!load) {
				request.getRequestDispatcher( "moncompte.jsp" ).forward( request, response );
				
			}
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
