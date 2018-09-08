package org.lanqiao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTool {
	public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	public static Connection getConn() {
		Connection conn = threadLocal.get();
		if (conn == null) {
			Properties prop = new Properties();
			try {
				prop.load(Class.forName("org.lanqiao.util.ConnectionTool")
						.getResourceAsStream("/org/lanqiao/util/jdbc.properties"));
				String url = prop.getProperty("url");
				Class.forName(prop.getProperty("driverClass"));
				conn = DriverManager.getConnection(url, prop.getProperty("user"), prop.getProperty("password"));
				threadLocal.set(conn);
				return conn;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public static void closeConnection() {
		Connection conn = threadLocal.get();
		if (conn != null) {
			try {
				if (!conn.isClosed()) {
					conn.close();
					threadLocal.remove();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
