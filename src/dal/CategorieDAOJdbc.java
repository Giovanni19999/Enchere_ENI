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
				BOCategorie cat=new BOCategorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				c.add(cat);
			}
	
			
		} catch (Exception e) {
			throw new Exception("11000");
		}
		return c;

	}
	
	
	
	public BOCategorie selectById(int id) throws Exception {
			
			BOCategorie cat=null;
			try (Connection cnx = ConnectionProvider.getConnection()){
				
			
				String sql = "SELECT * from CATEGORIES WHERE no_categorie= ?";
				
		
				
				PreparedStatement stmt = cnx.prepareStatement(sql);
		
				stmt.setInt(1, id);
				
				
				ResultSet rs = stmt.executeQuery();
				rs.next();
				cat=new BOCategorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				
			
		
				
			} catch (Exception e) {
				throw new Exception("11000");
			}
			return cat;
}
}