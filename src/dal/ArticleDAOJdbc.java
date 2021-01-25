package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import bo.BOArticle;

public class ArticleDAOJdbc {

	private static final String INSERT= "INSERT INTO [dbo].[ARTICLES_VENDUS] (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?)";
	
	public void VendreArticle(BOArticle article, int noUtilisateur) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
			String datedebut = article.getDebut().format(formatter);
			String datefin = article.getFin().format(formatter);
			
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setString(3, datedebut);
			pstmt.setString(4, datefin);
			pstmt.setInt(5, article.getPrixIni());
			pstmt.setInt(6, noUtilisateur);
			pstmt.setInt(7, article.getCategorie());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		
	}
}
