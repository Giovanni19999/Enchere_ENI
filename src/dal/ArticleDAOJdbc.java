package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import bo.BOArticle;

public class ArticleDAOJdbc {

	private static final String INSERT= "INSERT INTO [dbo].[ARTICLES_VENDUS] (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?)";
	
	public void VendreArticle(BOArticle article) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, new Timestamp(article.getDebut().getYear(), article.getDebut().getMonthValue()-1, article.getDebut().getDayOfMonth(), article.getDebut().getHour(), article.getDebut().getMinute(), article.getDebut().getSecond(), article.getDebut().getNano()) );
			pstmt.setTimestamp(4, new Timestamp(article.getFin().getYear(), article.getFin().getMonthValue()-1, article.getFin().getDayOfMonth(), article.getFin().getHour(), article.getFin().getMinute(), article.getFin().getSecond(), article.getFin().getNano()) );
			pstmt.setInt(5, article.getPrixIni());
			pstmt.setInt(6, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(7, article.getCategorie().getNoCategorie());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		
	}
}
