package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

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

/**
 * Servlet implementation class AjouterEnchere
 */
@WebServlet("/encheres/ajouter")
public class AjouterEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime dateString = LocalDateTime.now();
		
		String format = null;
		if(dateString.getMonthValue() < 10) {
			format = "0" + dateString.getMonthValue();
		} else {
			format = dateString.getMonthValue() + "";
		}
		
		
		String dateStringFormater = dateString.getYear() + "-" + format + "-" + dateString.getDayOfMonth() + "T" + dateString.getHour() + ":" + dateString.getMinute();
		request.setAttribute("dateMaintenant", dateStringFormater);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MiseEnVenteEnchere.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerArticle manager = new ManagerArticle();
		BOArticle article = new BOArticle();
		
		BOCategorie categorie = new BOCategorie();
		categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
		
		HttpSession session = request.getSession();
		BOUtilisateur utilisateur = null;
		utilisateur = (BOUtilisateur) session.getAttribute("utilisateur");
		
		article.setNom(request.getParameter("nomenchere"));
		article.setCategorie(categorie);
		article.setDebut(LocalDateTime.parse(request.getParameter("datedebutenchere") + ":00"));
		article.setFin(LocalDateTime.parse(request.getParameter("datefinenchere") + ":00"));
		article.setAdresse(request.getParameter("adresseretraitenchere"));
		article.setDescription(request.getParameter("descriptionenchere"));
		article.setPrixIni(Float.parseFloat((request.getParameter("prixenchere"))));
		article.setUtilisateur(utilisateur);
		
		manager.InsertArticle(article);
	}

}
