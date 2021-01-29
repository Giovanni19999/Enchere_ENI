package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOUtilisateur;
import managers.ManagerArticle;
import managers.ManagerCategorie;

/**
 * Servlet implementation class ServletRetourAccueil
 */
@WebServlet("/retour/encheres")
public class ServletRetourAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRetourAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ArrayList<BOArticle> article = null;
		ManagerArticle manager = new ManagerArticle();
		ManagerCategorie manCategorie = new ManagerCategorie();
		ArrayList<BOCategorie> listCat = null;
		try {
			listCat = manCategorie.recupererCategorie();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (session.getAttribute("utilisateur")== null) {
			article = manager.rechecheArticle("", "");
			
		} else {
			article = manager.rechecheArticleCo("", "", (BOUtilisateur) session.getAttribute("utilisateur"));
		}
		request.setAttribute("article", article);
		session.setAttribute("Categories", listCat);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Encheres.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		doGet(request, response);
	}

}
