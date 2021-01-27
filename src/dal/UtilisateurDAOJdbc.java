package dal;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.microsoft.sqlserver.jdbc.SQLServerDriver;



import bo.BOUtilisateur;





public class UtilisateurDAOJdbc {​​​​



	private static final String INSERT= "insert into (identifiant, mdp) values(?,?)";

public void insert (BOUtilisateur connexion) {​​​​

	try (Connection cnx = ConnectionProvider.getConnection()){​​​​
		PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
	pstmt.setString(1, connexion.getPseudo());
	pstmt.setString(2, connexion.getMdp());
	pstmt.executeUpdate();
	ResultSet rs = pstmt.getGeneratedKeys();
	if (rs.next()) {​​​​
		connexion.setPseudo(rs.getString(1));
	}​​​​
	}​​​​ catch (SQLException e) {​​​​
		// TODO Auto-generated catch block
		e.printStackTrace();
	}​​​​






}​​​​



public BOUtilisateur selectById(int id) throws Exception {​​​​
	BOUtilisateur c = null;
try (Connection cnx = ConnectionProvider.getConnection()){​​​​


	String sql = "SELECT * from UTILISATEURS WHERE no_utilisateur = ? ";



PreparedStatement stmt = cnx.prepareStatement(sql);

stmt.setInt(1,id);
ResultSet rs = stmt.executeQuery();




rs.next();
c = new BOUtilisateur();
c.setMdp(rs.getString("mot_de_passe"));
c.setPseudo(rs.getString("pseudo"));
c.setEmail(rs.getString("email"));
c.setNom(rs.getString("nom"));
c.setPrenom(rs.getString("prenom"));
c.setTelephone(rs.getString("telephone"));
c.setRue(rs.getString("rue"));
c.setCodePostal(rs.getString("code_postal"));
c.setVille(rs.getString("ville"));
c.setCredit(rs.getInt("credit"));
c.setAdminstrateur(rs.getBoolean("administrateur"));
c.setNoUtilisateur(rs.getInt("no_utilisateur"));

}​​​​ catch (Exception e) {​​​​
	throw new Exception("10000");
}​​​​
return c;



}​​​​
public BOUtilisateur selectByPseudo(String pseudo) throws Exception{​​​​
	BOUtilisateur c = null;
try (Connection cnx = ConnectionProvider.getConnection()){​​​​
	String sql = "SELECT * from UTILISATEURS WHERE pseudo = ? ";





PreparedStatement stmt = cnx.prepareStatement(sql);



stmt.setString(1,pseudo);
ResultSet rs = stmt.executeQuery();




rs.next();
c = new BOUtilisateur();
c.setMdp(rs.getString("mot_de_passe"));
c.setPseudo(rs.getString("pseudo"));
c.setEmail(rs.getString("email"));
c.setNom(rs.getString("nom"));
c.setPrenom(rs.getString("prenom"));
c.setTelephone(rs.getString("telephone"));
c.setRue(rs.getString("rue"));
c.setCodePostal(rs.getString("code_postal"));
c.setVille(rs.getString("ville"));
c.setCredit(rs.getInt("credit"));
c.setAdminstrateur(rs.getBoolean("administrateur"));
c.setNoUtilisateur(rs.getInt("no_utilisateur"));


}​​​​ catch (Exception e) {​​​​
	throw new Exception("10001");
}​​​​
return c;
}​​​​



public BOUtilisateur selectByEmail(String email) throws Exception{​​​​
	BOUtilisateur c = null;
try (Connection cnx = ConnectionProvider.getConnection()){​​​​
	String sql = "SELECT * from UTILISATEURS WHERE email = ? ";





PreparedStatement stmt = cnx.prepareStatement(sql);



stmt.setString(1,email);
ResultSet rs = stmt.executeQuery();




rs.next();
c = new BOUtilisateur();
c.setMdp(rs.getString("mot_de_passe"));
c.setPseudo(rs.getString("pseudo"));
c.setEmail(rs.getString("email"));
c.setNom(rs.getString("nom"));
c.setPrenom(rs.getString("prenom"));
c.setTelephone(rs.getString("telephone"));
c.setRue(rs.getString("rue"));
c.setCodePostal(rs.getString("code_postal"));
c.setVille(rs.getString("ville"));
c.setCredit(rs.getInt("credit"));
c.setAdminstrateur(rs.getBoolean("administrateur"));
c.setNoUtilisateur(rs.getInt("no_utilisateur"));




}​​​​ catch (Exception e) {​​​​
	throw new Exception("10002");
}​​​​
return c;
}​​​​




public void deleteById() throws Exception {​​​​
	try (Connection cnx = ConnectionProvider.getConnection()){​​​​
		String sql = "DELETE from UTILISATEURS WHERE no_utilisateur = ? ";


	PreparedStatement stmt = cnx.prepareStatement(sql);

	stmt.executeUpdate();
	}​​​​ catch (Exception e) {​​​​
		throw new Exception("10200");
	}​​​​





	}​​​​







public void updateById(BOUtilisateur user) throws SQLException {​​​​
	try (Connection cnx = ConnectionProvider.getConnection()){​​​​
		String sql = "UPDATE UTILISATEURS "
				+ "SET pseudo=?, mot_de_passe=?, nom=?, prenom=?,telephone=?,email=?,rue=?,code_postal=?,ville=?"+
				" WHERE no_utilisateur=?";

	PreparedStatement stmt = cnx.prepareStatement(sql);
	stmt.setString(1,user.getPseudo());
	stmt.setString(2,user.getMdp());
	stmt.setString(3,user.getNom());
	stmt.setString(4,user.getPrenom());
	stmt.setString(5,user.getTelephone());
	stmt.setString(6,user.getEmail());
	stmt.setString(7,user.getRue());
	stmt.setString(8,user.getCodePostal());
	stmt.setString(9,user.getVille());
	stmt.setInt(10,user.getNoUtilisateur());
	stmt.executeUpdate();
	}​​​​ catch (Exception e) {​​​​
		new Exception("10100");
	}​​​​
}​​​​



}​​​​