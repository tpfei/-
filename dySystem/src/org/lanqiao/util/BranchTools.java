package org.lanqiao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchTools {
	public static String getBranchName(String dept_upname) {
		Connection conn = ConnectionTool.getConn();
		String sql = "SELECT dept_name FROM t_dzb WHERE dept_id = ?" ;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_upname);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("DEPT_NAME");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
