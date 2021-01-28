package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.BOArticle;
import bo.BOCategorie;
import bo.BOEnchere;
import managers.ManagerArticle;
import managers.ManagerEnchere;

/**
 * Servlet implementation class ServletModifierEnchere
 */
@WebServlet("/modifier/enchere")
public class ServletModifierEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("numArticle");
		ManagerArticle manager = new ManagerArticle();
		BOArticle article= manager.rechercheUnArticle(Integer.parseInt(num));
		request.setAttribute("article", article);
		
		String formatMonth = null;
		String formatDay = null;
		String formatHour = null;
		String formatMin = null;
		LocalDateTime dateString = article.getDebut();
		
		
		if(dateString.getMonthValue() < 10) {
			formatMonth = "0" + dateString.getMonthValue();
		} else {
			formatMonth = dateString.getMonthValue() + "";
		}
		
		if(dateString.getDayOfMonth() < 10) {
			formatDay = "0" + dateString.getDayOfMonth();
		} else {
			formatDay = dateString.getDayOfMonth() + "";
		}
		
		if(dateString.getHour() < 10) {
			formatHour = "0" + dateString.getHour();
		} else {
			formatHour = dateString.getHour() + "";
		}
		
		if(dateString.getMinute() < 10) {
			formatMin = "0" + dateString.getMinute();
		} else {
			formatMin = dateString.getMinute() + "";
		}
		
		System.out.println(dateString.getYear());
		String dateStringFormater = dateString.getYear() + "-" + formatMonth + "-" + formatDay + "T" + formatHour + ":" + formatMin;
		
		request.setAttribute("debut", dateStringFormater);
		
		dateString = article.getFin();
		
		
		if(dateString.getMonthValue() < 10) {
			formatMonth = "0" + dateString.getMonthValue();
		} else {
			formatMonth = dateString.getMonthValue() + "";
		}
		
		if(dateString.getDayOfMonth() < 10) {
			formatDay = "0" + dateString.getDayOfMonth();
		} else {
			formatDay = dateString.getDayOfMonth() + "";
		}
		
		if(dateString.getHour() < 10) {
			formatHour = "0" + dateString.getHour();
		} else {
			formatHour = dateString.getHour() + "";
		}
		
		if(dateString.getMinute() < 10) {
			formatMin = "0" + dateString.getMinute();
		} else {
			formatMin = dateString.getMinute() + "";
		}
		
		System.out.println(dateString.getYear());
		dateStringFormater = dateString.getYear() + "-" + formatMonth + "-" + formatDay + "T" + formatHour + ":" + formatMin;
		
		request.setAttribute("fin", dateStringFormater);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierVente.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("numArticle");
		ManagerArticle manager = new ManagerArticle();
		BOArticle article= manager.rechercheUnArticle(Integer.parseInt(num));
		BOArticle modifArticle = new BOArticle();
		modifArticle.setNom(request.getParameter("nomenchere"));
		BOCategorie categorie = new BOCategorie();
		categorie.setNoCategorie(Integer.parseInt(request.getParameter("categorie")));
		modifArticle.setCategorie(categorie);
		article.setDebut(LocalDateTime.parse(request.getParameter("datedebutenchere") + ":00"));
		article.setFin(LocalDateTime.parse(request.getParameter("datefinenchere") + ":00"));
		article.setDescription(request.getParameter("descriptionenchere"));
		article.setPrixIni(Float.parseFloat((request.getParameter("prixenchere"))));
		modifArticle.setEtatInit(article.getEtatInit());
		modifArticle.setUtilisateur(article.getUtilisateur());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModifierEnchere.jsp");
		if(rd != null) {rd.forward(request, response);}
	}

}
