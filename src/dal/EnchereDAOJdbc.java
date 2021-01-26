package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class EnchereDAOJdbc {
	public ArrayList<Integer> selectArticleByUtilisateur(int idUser) throws Exception {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		try (Connection cnx = ConnectionProvider.getConnection()){
			
		
			String sql = "SELECT no_article from ENCHERES WHERE no_utilisateur=?";
			
			PreparedStatement stmt = cnx.prepareStatement(sql);
			
			
			stmt.setInt(1, idUser);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("no_article"));
			}
			
		}
		
		
		
		return list;
	}
}
