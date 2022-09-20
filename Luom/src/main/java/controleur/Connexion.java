package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Database;
import model.Favoris;
import model.FavorisDAO;
import model.User;
import model.UserDAO;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Servlet implementation class Connexion
 */
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Database.Connect();
		boolean messageinscriptionok=false;
		boolean messageconnexionbloque=false;
		if(request.getParameter("binscription")!= null) {
			String password=request.getParameter("password");
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			long mill  = System.currentTimeMillis();
			Date currentdate = new Date(mill);
			
			UserDAO userdao=new UserDAO();
			User u=new User(nom,prenom,currentdate,email,password);
			userdao.save(u);
			System.out.println("INSCRIPTION OK");
			messageinscriptionok=true;
		}
		request.setAttribute("messageinscriptionok", messageinscriptionok);
		
		boolean connected=false;
		boolean messageconnexionno=false;
		if(request.getParameter("bconnexion")!=null ) {
			String email=request.getParameter("cemail");
			String password=request.getParameter("cpassword");
			UserDAO utilisateurdao=new UserDAO();
			User u=utilisateurdao.connexion(email, password);
			if(u==null) {
				System.out.println("CONNEXION NO");
				messageconnexionno=true;
			}else if(u.isDel()==true) {
				System.out.println("CONNEXION NO");
				messageconnexionbloque=true;
				
			}else {
				System.out.println("CONNEXION OK");
				HttpSession session = request.getSession( true );
		        session.setAttribute( "userid", u.getId() );
		        session.setAttribute( "usernom", u.getNom() );
		        session.setAttribute( "isConnected", true );
		        FavorisDAO favorisdao = new FavorisDAO();
		        int userid=u.getId();
		        ArrayList<Favoris> favoris = favorisdao.getAllById(userid);
		        System.out.println(favoris);
		        session.setAttribute("favoris", favoris);
				connected=true;
				response.sendRedirect("Index");  
			}
		}
		request.setAttribute("messageconnexionno", messageconnexionno);
		request.setAttribute("messageconnexionbloque", messageconnexionbloque);
		
		if(connected==false) {
		request.getRequestDispatcher( "connexion.jsp" ).forward( request, response );
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
