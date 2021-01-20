package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import bo.BOConnection;



public class UtilisateurDAOJdbc {
	private Connection connection = null;

	private Connection getConnection() throws SQLException {
		if (connection == null) {
			DriverManager.registerDriver(new SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=BD_Encheres"; // Chargement du pilote JDBC
			connection = DriverManager.getConnection (url, "sa", "Pa$$w0rd");
		}
		return connection;
	}
	private static final String INSERT= "insert into (identifiant, mdp) values(?,?)";

	public void insert (BOConnection connexion) {
		if (connexion !=null) {


			try {
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, connexion.getNom());
				pstmt.setString(2, connexion.getMdp());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					connexion.setNom(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}
		
	}

	public BOConnection selectById(int id) throws Exception {
		
		
		String sql = "SELECT * from UTILISATEURS WHERE no_utilisateur = ? ";
		BOConnection c = null;

		Connection cnx = getConnection();
		PreparedStatement stmt = cnx.prepareStatement(sql);

		stmt.setInt(1,id);
		ResultSet rs = stmt.executeQuery();


		rs.next();
		c = new BOConnection();
		c.setMdp(rs.getString("mot_de_passe"));
		c.setNom(rs.getString("nom"));
		c.setEmail(rs.getString("email"));
		return c;

	}
		public BOConnection selectByPseudo(String pseudo) throws Exception{
			String sql = "SELECT * from UTILISATEURS WHERE pseudo = ? ";
			BOConnection c = null;

			
				Connection cnx = getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql);

				stmt.setString(1,pseudo);
				ResultSet rs = stmt.executeQuery();


				rs.next();
				c = new BOConnection();
				c.setMdp(rs.getString("mot_de_passe"));
				c.setNom(rs.getString("nom"));
				c.setEmail(rs.getString("email"));

			
			return c;
		}

		public BOConnection selectByEmail(String email) throws Exception{
			String sql = "SELECT * from UTILISATEURS WHERE email = ? ";
			BOConnection c = null;

			
				Connection cnx = getConnection();
				PreparedStatement stmt = cnx.prepareStatement(sql);

				stmt.setString(1,email);
				ResultSet rs = stmt.executeQuery();


				rs.next();
				c = new BOConnection();
				c.setMdp(rs.getString("mot_de_passe"));
				c.setNom(rs.getString("nom"));
				c.setEmail(rs.getString("email"));

			
			return c;
		}

	}

