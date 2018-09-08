package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.lanqiao.bean.Role;
import org.lanqiao.bean.User;
import org.lanqiao.dao.UserDao;
import org.lanqiao.util.ConnectionTool;

public class UserDaoImpl implements UserDao {
	User user;
	List<User> users;

	public boolean saveUser(String username, String roleId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String userId = UUID.randomUUID().toString();
		String sql = "INSERT INTO t_user(user_id , user_name) VALUES(?,?)";
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, username);
			pstmt.executeUpdate();

			sql = "INSERT INTO t_user_role VALUES(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, roleId);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {
		users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM t_user";
		ResultSet rs = null;
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("USER_ID"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("USER_PASSWORD"));
				users.add(user);
			}
			sql = "SELECT r.* FROM t_role r,t_user_role ur WHERE r.role_id = ur.role_id AND ur.user_id = ?";
			for (int i = 0; i < users.size(); i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, users.get(i).getUserId());
				rs = pstmt.executeQuery();
				while (rs.next()) {
					Role role = new Role();
					role.setRoleId(rs.getString("ROLE_ID"));
					role.setRoleName(rs.getString("ROLE_NAME"));
					users.get(i).getRoles().add(role);
				}
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public String getRoleName(String roleId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT role_name FROM t_role WHERE role_id = ?";
		ResultSet rs = null;
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roleId);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getString("ROLE_NAME");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(String username) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT user_id , user_password FROM t_user WHERE user_name = ?";
		ResultSet rs = null;
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			rs.next();
			User user = new User();
			user.setUserId(rs.getString("USER_ID"));
			user.setUsername(username);
			user.setPassword(rs.getString("USER_PASSWORD"));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updataUser(String username, String userId, String password, String roleId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_user SET user_name = ? ,user_password=? WHERE user_id=?";
		ResultSet rs = null;
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, userId);
			rs = pstmt.executeQuery();

			sql = "UPDATE t_user_role SET role_id = ? WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, roleId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(String userId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete from t_user_role where user_id=? ";
		String sql1 = " delete from t_user where user_id=? ";
		ResultSet rs = null;

		try {
			conn = ConnectionTool.getConn();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			pstm = conn.prepareStatement(sql1);
			pstm.setString(1, userId);
			rs = pstm.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionTool.closeConnection();
		}
		return false;
	}

}
