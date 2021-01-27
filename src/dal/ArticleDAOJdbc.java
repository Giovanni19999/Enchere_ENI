package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import bo.BOArticle;


public class ArticleDAOJdbc {

	private static final String INSERT= "INSERT INTO [dbo].[ARTICLES_VENDUS] (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?)";
	
	public void InsertArticle(BOArticle article) {
		
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, new Timestamp(article.getDebut().getYear(), article.getDebut().getMonthValue()-1, article.getDebut().getDayOfMonth(), article.getDebut().getHour(), article.getDebut().getMinute(), article.getDebut().getSecond(), article.getDebut().getNano()) );
			pstmt.setTimestamp(4, new Timestamp(article.getFin().getYear(), article.getFin().getMonthValue()-1, article.getFin().getDayOfMonth(), article.getFin().getHour(), article.getFin().getMinute(), article.getFin().getSecond(), article.getFin().getNano()) );
			pstmt.setFloat(5, article.getPrixIni());
			pstmt.setInt(6, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(7, article.getCategorie().getNoCategorie());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<BOArticle> selctByCat(String rec,int cat){
		
		ArrayList<BOArticle> c = new ArrayList<BOArticle>();
		try (Connection cnx = ConnectionProvider.getConnection()){
			
		
			String sql = "SELECT * from ARTICLES_VENDUS WHERE no_categorie=? AND nom_article LIKE '%?%'";
			
			
			
			PreparedStatement stmt = cnx.prepareStatement(sql);
			
			stmt.setInt(1, cat);
			stmt.setString(2, rec);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BOArticle art =new BOArticle();
				
				art.setNumero(rs.getInt("no_article"));
				art.setNom(rs.getString("nom_article"));
				art.setDescription(rs.getString("description"));
				art.setDebut(rs.getTimestamp("date_debut_enchere").toLocalDateTime());
				art.setFin(rs.getTimestamp("date_fin_enchere").toLocalDateTime());
				art.setPrixIni(rs.getFloat("prix_initial"));
				art.setUtilisateur(new UtilisateurDAOJdbc().selectById(rs.getInt("no_utilisateur")));
				art.setCategorie(new CategorieDAOJdbc().selectById(cat));
				art.setEtatInit(rs.getString("etat_vente"));
				
				c.add(art);
			}
		
		
			
		}catch (Exception e) {
			
		}
		return c;
		
	}
	public BOArticle selctById(int noArt){
		BOArticle art =new BOArticle();
		try (Connection cnx = ConnectionProvider.getConnection()){
			
			
			String sql = "SELECT * from ARTICLES_VENDUS WHERE no_article=?";
			
			
			
			PreparedStatement stmt = cnx.prepareStatement(sql);
			
			
			stmt.setInt(1, noArt);
			
			ResultSet rs = stmt.executeQuery();
			
			
			
				
			art.setNumero(rs.getInt("no_article"));
			art.setNom(rs.getString("nom_article"));
			art.setDescription(rs.getString("description"));
			art.setDebut(rs.getTimestamp("date_debut_enchere").toLocalDateTime());
			art.setFin(rs.getTimestamp("date_fin_enchere").toLocalDateTime());
			art.setPrixIni(rs.getFloat("prix_initial"));
			art.setUtilisateur(new UtilisateurDAOJdbc().selectById(rs.getInt("no_utilisateur")));
			art.setCategorie(new CategorieDAOJdbc().selectById(rs.getInt("no_categorie")));
			art.setEtatInit(rs.getString("etat_vente"));
				
				
			
		
		
			
		}catch (Exception e) {
			
		}
		return art;
		
	}
	
	
	
	
	public ArrayList<BOArticle> selctByRecherche(String rec){
			
			ArrayList<BOArticle> c = new ArrayList<BOArticle>();
			try (Connection cnx = ConnectionProvider.getConnection()){
				
			
				String sql = "SELECT * from ARTICLES_VENDUS WHERE nom_article LIKE ? ";
				
				
				System.out.println(rec);
				PreparedStatement stmt = cnx.prepareStatement(sql);
				
				System.out.println("je suis là");
				System.out.println(stmt);
				
				stmt.setString(1, "%"+ rec+"%");
				
				System.out.println("je suis là");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					BOArticle art =new BOArticle();
					
					art.setNumero(rs.getInt("no_article"));
					art.setNom(rs.getString("nom_article"));
					art.setDescription(rs.getString("description"));
					art.setDebut(rs.getTimestamp("date_debut_enchere").toLocalDateTime());
					art.setFin(rs.getTimestamp("date_fin_enchere").toLocalDateTime());
					art.setPrixIni(rs.getFloat("prix_initial"));
					art.setUtilisateur(new UtilisateurDAOJdbc().selectById(rs.getInt("no_utilisateur")));
					art.setCategorie(new CategorieDAOJdbc().selectById(rs.getInt("no_categorie")));
					art.setEtatInit(rs.getString("etat_vente"));
					c.add(art);
					
				}
			
			
				
			}catch (Exception e) {
				
			}
			return c;
	
	}
	
	public int selectNumByArticle(BOArticle art) {
		int num=0;
		try (Connection cnx = ConnectionProvider.getConnection()){
			String sql = "SELECT no_article from ARTICLES_VENDUS WHERE ?=nom_article AND description=? AND date_debut_enchere=? AND date_fin_enchere=? AND prix_initial=? AND no_categorie=? AND etat_vente=?";
			PreparedStatement stmt = cnx.prepareStatement(sql);
			
			
			
			
			stmt.setString(1, art.getNom());
			stmt.setString(2, art.getDescription());
			stmt.setTimestamp(3, new Timestamp(art.getDebut().getYear(), art.getDebut().getMonthValue()-1, art.getDebut().getDayOfMonth(), art.getDebut().getHour(), art.getDebut().getMinute(), art.getDebut().getSecond(), art.getDebut().getNano()) );
			stmt.setTimestamp(4, new Timestamp(art.getFin().getYear(), art.getFin().getMonthValue()-1, art.getFin().getDayOfMonth(), art.getFin().getHour(), art.getFin().getMinute(), art.getFin().getSecond(), art.getFin().getNano()) );
			stmt.setFloat(1, art.getPrixIni());
			stmt.setInt(1, art.getCategorie().getNoCategorie());
			stmt.setString(1, art.getEtatInit());
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			num=rs.getInt("no_article");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
			
	}
	
	
}
