package dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {

		Connection cnx = null;
		Context context;
		try {
			context = new InitialContext();
			DataSource datasource= (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			cnx = datasource.getConnection();
		} catch (NamingException e) {
			throw new RuntimeException("Impossible de se connecter à la base de données");
		}
		return cnx;
	}
}