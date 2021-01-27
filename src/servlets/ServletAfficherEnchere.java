package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BOArticle;
import managers.ManagerArticle;

/**
 * Servlet implementation class ServletAfficherEnchere
 */
@WebServlet("/afficher/enchere")
public class ServletAfficherEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAfficherEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerArticle manager = new ManagerArticle();
		BOArticle article = null;
		
		
		
		
		
		String numString = request.getParameter("noArticle");
		if(numString !=null) {			
			article = manager.rechercheUnArticle(Integer.parseInt(numString));
			request.setAttribute ("article",article);
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Enchere.jsp");
		if(rd != null) {rd.forward(request, response);}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Enchere.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

}
