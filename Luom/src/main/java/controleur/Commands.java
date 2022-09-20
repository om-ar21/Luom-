package controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Commande;
import model.CommandeDAO;
import model.Database;
import model.Detail;
import model.DetailDAO;
import model.Produit;
import model.ProduitDAO;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Commands
 */
public class Commands extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commands() {
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
		
		if(session.getAttribute("userid")==null) {
			load=true;
			response.sendRedirect("Notconnected");
		}
		int idclient = (int) session.getAttribute("userid");
		int id= Integer.valueOf(request.getParameter("idc")); 
		
		CommandeDAO cmddao = new CommandeDAO();
		
		ArrayList<Commande> cmds = cmddao.getAllById(idclient);
		
		boolean ver = false;
		for(Commande cm:cmds) {
			if(cm.getId()==id) {
				ver=true;
			}
		}
		
		if(ver==true) {
			DetailDAO dtdao = new DetailDAO();
			
			ArrayList<Detail> prdscmd = dtdao.getAllByCommande(id);
			
			Commande cmd = cmddao.getById(id);
			
			request.setAttribute("To", cmd.getTotal());
			request.setAttribute("nm", cmd.getId());
			
			if(request.getParameter("retirerprod")!=null ) {
                load =true;
                int idprod= Integer.valueOf(request.getParameter("retirerprod"));
                ProduitDAO pdao = new ProduitDAO();

                Detail d = dtdao.getById(idprod);
                Produit p = pdao.getById(d.getId_produits());

                int qte = d.getQte();
                int stockprod = p.getStock();
                double prix = d.getPrix();
                p.setStock(qte+stockprod);
                cmd.setTotal(cmd.getTotal()-prix);
                dtdao.hideById(idprod);
                cmddao.save(cmd);
                pdao.save(p);
                dtdao.save(d);



                response.sendRedirect(request.getHeader("referer"));
            }
			
			if(request.getParameter("annulercmd")!=null) {

                int idcom= Integer.valueOf(request.getParameter("annulercmd"));

                ArrayList<Detail> dt = dtdao.getAllByCommande(idcom);
                for(Detail pc : dt) {
                    ProduitDAO pdao = new ProduitDAO();

                    Detail d = dtdao.getById(pc.getId());
                    Produit p = pdao.getById(d.getId_produits());

                    int qte = d.getQte();
                    int stockprod = p.getStock();
                    p.setStock(qte+stockprod);
                    dtdao.hideById(pc.getId());
                    pdao.save(p);
                    dtdao.save(d);

                }

                cmddao.deleteById(idcom);
                load=true;
                response.sendRedirect("Moncompte");

            }
			
			request.setAttribute("prdscmd", prdscmd);
			
			if(!load) {
			request.getRequestDispatcher("commands.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("NotFound");
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
