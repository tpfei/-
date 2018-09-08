package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.bean.Menu;
import org.lanqiao.bean.Role;
import org.lanqiao.bean.User;
import org.lanqiao.dao.LoginDao;
import org.lanqiao.util.ConnectionTool;

public class LoginDaoImpl implements LoginDao {
	User user ;
	public User login(String username, String password) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_user WHERE user_name = ? AND user_password = ?";
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User() ;
				user.setUserId(rs.getString("USER_ID"));
				user.setUsername(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("user_password"));
			}
			sql = "SELECT r.* FROM t_role r,t_user_role ur WHERE r.role_id = ur.role_id AND ur.user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRoleId(rs.getString("ROLE_ID"));
				role.setRoleName(rs.getString("ROLE_NAME"));
				user.getRoles().add(role);
			}
			sql = "SELECT * FROM t_menu m ,t_role_menu rm WHERE m.menu_id = rm.menu_id AND rm.role_id = ? ";
			pstmt = conn.prepareStatement(sql);
			for (Role role : user.getRoles()) {
				pstmt.setString(1,role.getRoleId());
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					Menu menu=new Menu();
					menu.setMenuId(rs.getString("MENU_ID"));
					menu.setParentId(rs.getString("T_M_MENU_ID"));
					menu.setMenuName(rs.getString("MENU_NAME"));
					menu.setURL(rs.getString("URL"));
					menu.setIsParent(rs.getString("ISPARENT"));
					role.getMenus().add(menu);
				}
			}
			return user ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
