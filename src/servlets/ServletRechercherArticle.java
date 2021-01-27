package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BOCategorie;
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
		
		String categorie = request.getParameter("categorie");
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/fragments/Navigation.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/*
	 * 
	 
	private String lireCategorie(HttpServletRequest request, List<String> listeCodesErreur) {
		String ListeCategorie=null;
		try
		{
			if(request.getParameter("categorie")!=null)
			{
				ListeCategorie =(request.getParameter("categorie"));
			}
		}
		catch(BusinessException e)
		{
			e.printStackTrace();
			
		}
		return ListeCategorie;
	}
	*/

}
