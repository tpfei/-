package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.bean.Dangyuan;
import org.lanqiao.bean.User;
import org.lanqiao.dao.DangyuanDao;
import org.lanqiao.util.ConnectionTool;

public class DangyuanDaoImpl implements DangyuanDao {

	public List<Dangyuan> getAllDangyuan() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM t_dy";
		List<Dangyuan> allDangyuan = new ArrayList<Dangyuan>();
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Dangyuan dangyuan = new Dangyuan();
				dangyuan.setDyId(rs.getString("DY_ID"));
				dangyuan.setZbId(rs.getString("DEPT_ID"));
				dangyuan.setName(rs.getString("DY_NAME"));
				dangyuan.setSex(rs.getString("DY_SEX"));
				dangyuan.setJiguan(rs.getString("DY_NATIVE"));
				dangyuan.setMingzu(rs.getString("DY_NATION"));
				dangyuan.setSfzhm(rs.getString("DY_SFZ"));
				dangyuan.setRylb(rs.getString("DY_SORT"));
				dangyuan.setSqrdsj(rs.getString("DY_SQTIME"));
				dangyuan.setLwjjfzsj(rs.getString("DY_JJFZTIME"));
				dangyuan.setBylxr(rs.getString("DY_LXR"));
				dangyuan.setFzdxsj(rs.getString("DY_SURE"));
				dangyuan.setRdjxr(rs.getString("DY_RDJSR"));
				dangyuan.setRdsj(rs.getString("DY_TIME"));
				dangyuan.setDwspsj1(rs.getString("DY_YBSP"));
				dangyuan.setZzsj(rs.getString("DY_ZZTIME"));
				dangyuan.setDwspsj2(rs.getString("DY_ZZSP"));
				dangyuan.setLxfs(rs.getString("DY_RELATION"));
				dangyuan.setJtzz(rs.getString("DY_ADDRESS"));
				dangyuan.setNewZbName(rs.getString("DY_NEWDEPT"));
				dangyuan.setOutTime(rs.getString("out_time"));
				// dangyuan.setZbName(zbName);
				// System.out.println(dangyuan.getDyId());
				allDangyuan.add(dangyuan);
			}

			return allDangyuan;
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

	public void out(String dyName, String NewZbName) {
		System.out.println("sss" + NewZbName + dyName);
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_dy SET DY_NEWDEPT = ? WHERE dy_Name=?";
		conn = ConnectionTool.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NewZbName);
			pstmt.setString(2, dyName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionTool.closeConnection();
		}
	}

	public int saveDangyuan(Dangyuan dangyuan) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into t_dy values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'','')";
		conn = ConnectionTool.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dangyuan.getDyId());
			pstmt.setString(2, dangyuan.getZbId());
			pstmt.setString(3, dangyuan.getName());
			pstmt.setString(4, dangyuan.getSex());
			pstmt.setString(5, dangyuan.getJiguan());
			pstmt.setString(6, dangyuan.getMingzu());
			pstmt.setString(7, dangyuan.getSfzhm());
			pstmt.setString(8, dangyuan.getRylb());
			pstmt.setString(9, dangyuan.getSqrdsj());
			pstmt.setString(10, dangyuan.getLwjjfzsj());
			pstmt.setString(11, dangyuan.getBylxr());
			pstmt.setString(12, dangyuan.getFzdxsj());
			pstmt.setString(13, dangyuan.getRdjxr());
			pstmt.setString(14, dangyuan.getRdsj());
			pstmt.setString(15, dangyuan.getDwspsj1());
			pstmt.setString(16, dangyuan.getZzsj());
			pstmt.setString(17, dangyuan.getDwspsj2());
			pstmt.setString(18, dangyuan.getLxfs());
			pstmt.setString(19, dangyuan.getJtzz());
			// pstmt.setString(20, "1");
			pstmt.executeUpdate();
			sql = "insert into t_coststate(DY_ID,DY_NAME,coststate) values (?,?,'н╢╫иди')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dangyuan.getDyId());
			pstmt.setString(2, dangyuan.getName());
			pstmt.executeQuery();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}

	public int deleteDangyuan(String sfzhm) {
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " delete from t_dy where dy_sfz=?";
		conn = ConnectionTool.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sfzhm);
			pstmt.executeUpdate();
			return 1;
		} */
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql =" delete from t_coststate where dy_id=?";
		String sql1 =" delete from t_dy where dy_id=?";
		conn = ConnectionTool.getConn();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, sfzhm);
			pstmt.executeUpdate();
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, sfzhm);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}

	public Dangyuan selectDangyuan(String dyName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from t_dy where dy_name=?";
		conn = ConnectionTool.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dyName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dangyuan dangyuan = new Dangyuan();
				dangyuan.setDyId(rs.getString("DY_ID"));
				dangyuan.setZbId(rs.getString("DEPT_ID"));
				dangyuan.setName(rs.getString("DY_NAME"));
				dangyuan.setSex(rs.getString("DY_SEX"));
				dangyuan.setJiguan(rs.getString("DY_NATIVE"));
				dangyuan.setMingzu(rs.getString("DY_NATION"));
				dangyuan.setSfzhm(rs.getString("DY_SFZ"));
				dangyuan.setRylb(rs.getString("DY_SORT"));
				dangyuan.setSqrdsj(rs.getString("DY_SQTIME"));
				dangyuan.setLwjjfzsj(rs.getString("DY_JJFZTIME"));
				dangyuan.setBylxr(rs.getString("DY_LXR"));
				dangyuan.setFzdxsj(rs.getString("DY_SURE"));
				dangyuan.setRdjxr(rs.getString("DY_RDJSR"));
				dangyuan.setRdsj(rs.getString("DY_TIME"));
				dangyuan.setDwspsj1(rs.getString("DY_YBSP"));
				dangyuan.setZzsj(rs.getString("DY_ZZTIME"));
				dangyuan.setDwspsj2(rs.getString("DY_ZZSP"));
				dangyuan.setLxfs(rs.getString("DY_RELATION"));
				dangyuan.setJtzz(rs.getString("DY_ADDRESS"));

				return dangyuan;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	public Dangyuan viewDangyuan(String dyName,String sfzhm){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="select y.*,b.dept_name from t_dy y,t_dzb b where y.dept_id=b.dept_id and dy_name=? and dy_sfz=?";
		conn=ConnectionTool.getConn();
		ResultSet rs=null;
		try {
			Dangyuan dangyuan=new Dangyuan();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dyName);
			pstmt.setString(2,sfzhm);
			rs=pstmt.executeQuery();
			while(rs.next()){
				dangyuan.setName(rs.getString("dy_name"));
				dangyuan.setSfzhm(rs.getString("dy_sfz"));
				dangyuan.setZbName(rs.getString("dept_name"));
				dangyuan.setNewZbName(rs.getString("DY_NEWDEPT"));
				dangyuan.setOutTime(rs.getString("out_time"));
			}
			return dangyuan;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean del(String sfzid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE t_dy SET dy_NEWDEPT = null WHERE dy_sfz=?";
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sfzid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	@Override
	public int updateDangyuan(Dangyuan dangyuan) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE  t_dy SET dy_name=?,dy_sfz=?,dy_sex=?,dy_nation=?,dy_time=?,dy_sort=?,dept_id=?,dy_relation=? WHERE dy_id=?";
		conn = ConnectionTool.getConn();
		try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dangyuan.getName());
				pstmt.setString(2, dangyuan.getSfzhm());
				pstmt.setString(3, dangyuan.getSex());
				pstmt.setString(4, dangyuan.getMingzu());
				pstmt.setString(5, dangyuan.getRdsj());
				pstmt.setString(6, dangyuan.getRylb());
				pstmt.setString(7, dangyuan.getZbId());
				pstmt.setString(8, dangyuan.getLxfs());
				pstmt.setString(9, dangyuan.getDyId());
				pstmt.executeUpdate();
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
