package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bo.BOCategorie;


public class CategorieDAOJdbc {
	public ArrayList<BOCategorie> selectAll() throws Exception {
		
		 ArrayList<BOCategorie> c = new ArrayList<BOCategorie>();
		try (Connection cnx = ConnectionProvider.getConnection()){
			
		
			String sql = "SELECT * from CATEGORIES";
			
	
			
			PreparedStatement stmt = cnx.prepareStatement(sql);
	
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BOCategorie cat=new BOCategorie(rs.getInt("no_categorie"), "libelle");
				c.add(cat);
			}
	
			
		} catch (Exception e) {
			throw new Exception("11000");
		}
		return c;

	}
}
