package managers;

import bo.BOArticle;
import dal.ArticleDAOJdbc;

public class ManagerArticle {

	public void VendreArticle(BOArticle article) {
		ArticleDAOJdbc ArticleDAO = new ArticleDAOJdbc();
		ArticleDAO.VendreArticle(article);
	}
}

