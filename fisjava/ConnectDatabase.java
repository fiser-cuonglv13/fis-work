package fisjava;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDatabase {

	static Connection conn = null;
	static String url = "jdbc:mysql://localhost:3306/fis";
	static String driver = "com.mysql.jdbc.Driver";// Driver kết nối với MySQL
	static String userName = "root";
	static String password = "cuonglv13!@#";

	/* Tạo kết nối */
	public static Connection getConnection() {
		try {

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, userName, password);

		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
			System.out.println("Không thể kết nối");
		}
		return conn;
	}

	/* Đóng kết nối */
	public void close() {
		try {
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}
	
	public static void main(String args[]) throws SQLException {
		getConnection();
		Statement stm = (Statement)conn.createStatement();
		stm.executeQuery("SELECT u1.name,u2.name "
				+ "FROM (user u1 JOIN user u2) "+ " JOIN lover l "
				+ "on u1.idUser = l.user1 "
				+ "and u2.idUser = l.user2");
		ResultSet rs = stm.getResultSet();
		while (rs.next()) {
			String user1= rs.getString(1); 
			String user2 = rs.getString(2);
                        System.out.println(user1 + " love "+ user2);
		}
		rs.close();
		stm.close();
	}
}
