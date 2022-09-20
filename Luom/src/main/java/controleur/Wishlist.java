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

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Wishlist
 */
public class Wishlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wishlist() {
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
		if(session.getAttribute("isConnected")==null) {
			session.setAttribute( "isConnected", false );
		}
		FavorisDAO favorisdao=new FavorisDAO();
		if(session.getAttribute("userid")!=null) {
			
			int userid=(int)session.getAttribute("userid");
		ArrayList<Favoris> fav = favorisdao.getAllById(userid);
	
		
		if(request.getParameter("delete")!=null) {
			load=true;
			int idp = Integer.valueOf(request.getParameter("delete"));
			
			favorisdao.hideByIdFav(idp);
			response.sendRedirect(request.getHeader("referer"));
		}
		request.setAttribute("fav", fav);
		}
		
		if(!load) {
			request.getRequestDispatcher( "wishlist.jsp" ).forward( request, response );
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
