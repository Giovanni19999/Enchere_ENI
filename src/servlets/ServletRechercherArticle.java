package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import exceptions.BusinessException;
import managers.ManagerArticle;
import managers.ManagerCategorie;
import message.CodeErreur;

/**
 * Servlet implementation class ServletRechercherArticle
 */
@WebServlet("/article/rechercher")
public class ServletRechercherArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRechercherArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerArticle manager = new ManagerArticle();
		ArrayList<BOArticle> article= null;
		String categorie = request.getParameter("categorie");
		String recherche = request.getParameter("nomRecherche");
		HttpSession session = request.getSession();
		
		if (session.getAttribute("utilisateur")== null) {
			article = manager.rechecheArticle(recherche, categorie);
			
		} else {
			article = manager.rechecheArticleCo(recherche, categorie, (BOUtilisateur) session.getAttribute("utilisateur"));
		}
		request.setAttribute("article", article);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ListeEnchere.jsp");
		if(rd != null) {rd.forward(request, response);}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	 
	 
	
	
	

}
