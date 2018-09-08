package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.bean.Pay;
import org.lanqiao.dao.PayDao;
import org.lanqiao.util.ConnectionTool;
import org.lanqiao.util.PageModel2;


public class PayDaoImpl implements PayDao {

	@SuppressWarnings("resource")
	@Override
	public PageModel2<Pay> showPay(int currentPageNo,int rows) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM (SELECT rownum rn,t.* FROM t_coststate t WHERE rownum<=?) WHERE rn>=?";

		int endRow = rows * currentPageNo;
		int startRow = (currentPageNo - 1) * rows + 1;
		int totalRows = 0;
		int pages = 0;
		ResultSet rs = null;
		System.out.println(endRow + " dao "+startRow);
		PageModel2<Pay> pm = new PageModel2<Pay>();
		List<Pay> roles = new ArrayList<Pay>();
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Pay pay = new Pay();
				pay.setDy_id(rs.getString("dy_id"));
				pay.setCoststate(rs.getString("coststate"));
				pay.setDy_name(rs.getString("dy_name"));
				roles.add(pay);
			}
			sql = "SELECT COUNT(*) FROM t_coststate";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRows = rs.getInt(1);
			pm.setRows(roles);
			pages = totalRows % rows == 0 ? totalRows / rows
					: totalRows / rows + 1;
			pm.setPages(pages);
			pm.setTotal(totalRows);
			return pm;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ConnectionTool.closeConnection();
		}
		return null;
	}
	
	
	@Override
	public int updatePay(String dy_id) {
		Connection conn = null;
		String sql = "update t_coststate set coststate='已缴费' where dy_id=?";
		int token = 0;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dy_id);
			System.out.println("dao"+dy_id);
			token = pstmt.executeUpdate();
			return token;
		}catch (Exception e) {
			
		}finally {
			ConnectionTool.closeConnection();
		}
		return token;
	}

	@Override
	public void delPay() {

	}

	@Override
	public void addPay() {

	}
}
