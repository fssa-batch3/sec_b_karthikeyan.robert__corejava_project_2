package in.fssa.knfunding.util;
import java.sql.*;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {




		public static Connection getConnection() {
			
			Dotenv env = Dotenv.load();
			String url = env.get("DATABASE_HOST");
			String username = env.get("DATABASE_USERNAME");
			String password = env.get("DATABASE_PASSWORD");
			
			

			Connection conn = null;
			
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, username, password);

			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			return conn;

		}

		public static void close(Connection connection, PreparedStatement presta) {
			try {
				if (presta != null) {
					presta.close();
				}
				if (connection != null) {

					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		

		public static void close(Connection connection, PreparedStatement presta, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
				}
				if (presta != null) {
					presta.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

