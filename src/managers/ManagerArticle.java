package managers;

import bo.BOArticle;
import dal.ArticleDAOJdbc;

public class ManagerArticle {

	public void InsertArticle(BOArticle article) {
		ArticleDAOJdbc ArticleDAO = new ArticleDAOJdbc();
		ArticleDAO.InsertArticle(article);
	}
}

