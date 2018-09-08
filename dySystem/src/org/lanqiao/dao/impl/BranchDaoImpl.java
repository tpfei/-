package org.lanqiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lanqiao.bean.Branch;
import org.lanqiao.bean.Dangyuan;
import org.lanqiao.dao.BranchDao;
import org.lanqiao.util.ConnectionTool;
import org.lanqiao.util.PageModel;

public class BranchDaoImpl implements BranchDao {
	public Branch branch;

	public PageModel<Branch> getBranch(int currentPage, String deptName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM t_dzb WHERE dept_name=? ORDER BY dept_id) t WHERE rownum<=?) WHERE rn>=?";
		int rowsPerPage = 3;
		int endRow = rowsPerPage * currentPage;
		int startRow = (currentPage - 1) * rowsPerPage + 1;
		int totalRows = 0;
		int totalPage = 0;
		ResultSet rs = null;
		PageModel<Branch> pm = new PageModel<Branch>();
		List<Branch> branchs = new ArrayList<Branch>();
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptName);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setDept_id(rs.getString("dept_id"));
				branch.setDept_name(rs.getString("dept_name"));
				branch.setDept_upname(rs.getString("dept_upname"));
				branch.setDept_sj(rs.getString("dept_sj"));
				branch.setDept_lxr(rs.getString("dept_lxr"));
				branch.setDept_tel(rs.getString("dept_tel"));
				branch.setDept_sort(rs.getString("dept_sort"));
				branchs.add(branch);
			}
			sql = "SELECT COUNT(*) FROM t_dzb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRows = rs.getInt(1);
			pm.setList(branchs);
			totalPage = totalRows % rowsPerPage == 0 ? totalRows / rowsPerPage : totalRows / rowsPerPage + 1;
			pm.setTotalPage(totalPage);
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

	public boolean deleteBranch(String branchId) {
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "delete from t_dzb where dept_id=? ";
		String sql1 = "SELECT * from t_dzb ,t_dy where  t_dzb.dept_id=t_dy.dept_id AND t_dzb.dept_id=? ";
		ResultSet rs=null;
		conn = ConnectionTool.getConn();

		try {
			
			pstm = conn.prepareStatement(sql1);
			pstm.setString(1, branchId);
			rs=pstm.executeQuery();
			if(rs.next()){
				return false;
			}else{
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, branchId);
				pstm.executeUpdate();
				System.out.println("delete seccess");
			}
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			ConnectionTool.closeConnection();
		}

	}

	public boolean saveBranch(Branch branch) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO t_dzb VALUES(?,?,?,?,?,?,?)";
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, branch.getDept_id());
			pstmt.setString(2, branch.getDept_name());
			pstmt.setString(3, branch.getDept_upname());
			pstmt.setString(4, branch.getDept_sj());
			pstmt.setString(5, branch.getDept_lxr());
			pstmt.setString(6, branch.getDept_tel());
			pstmt.setString(7, branch.getDept_sort());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}finally{
			ConnectionTool.closeConnection();
		}
	}

	public PageModel<Branch> getAllBranch(int currentPage) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM t_dzb ORDER BY dept_id) t WHERE rownum<=?) WHERE rn>=?";
		int rowsPerPage = 3;
		int endRow = rowsPerPage * currentPage;
		int startRow = (currentPage - 1) * rowsPerPage + 1;
		int totalRows = 0;
		int totalPage = 0;
		ResultSet rs = null;
		PageModel<Branch> pm = new PageModel<Branch>();
		List<Branch> branchs = new ArrayList<Branch>();
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setDept_id(rs.getString("dept_id"));
				branch.setDept_name(rs.getString("dept_name"));
				branch.setDept_upname(rs.getString("dept_upname"));
				branch.setDept_sj(rs.getString("dept_sj"));
				branch.setDept_lxr(rs.getString("dept_lxr"));
				branch.setDept_tel(rs.getString("dept_tel"));
				branch.setDept_sort(rs.getString("dept_sort"));
				branchs.add(branch);
			}
			sql = "SELECT COUNT(*) FROM t_dzb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalRows = rs.getInt(1);
			pm.setList(branchs);
			totalPage = totalRows % rowsPerPage == 0 ? totalRows / rowsPerPage : totalRows / rowsPerPage + 1;
			pm.setTotalPage(totalPage);
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

	public Branch getBranchById(String dept_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM t_dzb WHERE dept_id=? ";

		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			branch = new Branch();
			branch.setDept_id(dept_id);
			branch.setDept_name(rs.getString("dept_name"));
			branch.setDept_upname(rs.getString("dept_upname"));
			branch.setDept_sj(rs.getString("dept_sj"));
			branch.setDept_lxr(rs.getString("dept_lxr"));
			branch.setDept_tel(rs.getString("dept_tel"));
			branch.setDept_sort(rs.getString("dept_sort"));
			return branch;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionTool.closeConnection();
		}
		return null;
	}
/* 更新数据，首先查询是否有其他支部有了该ID，若有则不能更新
 * 实现方式，ID存在且不是自己的则不能更新
 * */
	public boolean updateBranch(Branch branch) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql1="SELECT dept_name FROM t_dzb WHERE dept_id=? AND dept_name!=?";
		String sql = "UPDATE t_dzb SET dept_name=? ,dept_sj=? ,dept_lxr=?,dept_tel=?,dept_sort=? WHERE dept_id = ?";
		conn = ConnectionTool.getConn();
		try {
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, branch.getDept_id());
			pstmt.setString(2, branch.getDept_name());
			rs=pstmt.executeQuery();
			if(!rs.next()){
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, branch.getDept_name());
			pstmt.setString(2, branch.getDept_sj());
			pstmt.setString(3, branch.getDept_lxr());
			pstmt.setString(4, branch.getDept_tel());
			pstmt.setString(5, branch.getDept_sort());
			pstmt.setString(6, branch.getDept_id());
			pstmt.executeUpdate();
			return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			return false;
		}finally{
			ConnectionTool.closeConnection();
		}
		
	}
//*********************************************************************************************
	@Override
	public List<Branch> getAllBranch2() {
		String sql="SELECT * FROM t_dzb  ORDER BY dept_id";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		List<Branch> branchs = new ArrayList<Branch>();
		try {
			conn = ConnectionTool.getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Branch branch = new Branch();
				branch.setDept_id(rs.getString("dept_id"));
				branch.setDept_name(rs.getString("dept_name"));
				branch.setDept_upname(rs.getString("dept_upname"));
				branch.setDept_sj(rs.getString("dept_sj"));
				branch.setDept_lxr(rs.getString("dept_lxr"));
				branch.setDept_tel(rs.getString("dept_tel"));
				branch.setDept_sort(rs.getString("dept_sort"));
				String sql1="SELECT * FROM t_dy WHERE dept_id=?";
				PreparedStatement pstm=conn.prepareStatement(sql1);
				pstm.setString(1,branch.getDept_id());
				ResultSet rs1=pstm.executeQuery();
				while(rs1.next()){
					
					Dangyuan dangyuan=new Dangyuan();
					dangyuan.setDyId(rs1.getString("DY_ID"));
					dangyuan.setZbId(rs1.getString("DEPT_ID"));
					dangyuan.setName(rs1.getString("DY_NAME"));
					dangyuan.setSex(rs1.getString("DY_SEX"));
					dangyuan.setJiguan(rs1.getString("DY_NATIVE"));
					dangyuan.setMingzu(rs1.getString("DY_NATION"));
					dangyuan.setSfzhm(rs1.getString("DY_SFZ"));
					dangyuan.setRylb(rs1.getString("DY_SORT"));
					dangyuan.setSqrdsj(rs1.getString("DY_SQTIME"));
					dangyuan.setLwjjfzsj(rs1.getString("DY_JJFZTIME"));
					dangyuan.setBylxr(rs1.getString("DY_LXR"));
					dangyuan.setFzdxsj(rs1.getString("DY_SURE"));
					dangyuan.setRdjxr(rs1.getString("DY_RDJSR"));
					dangyuan.setRdsj(rs1.getString("DY_TIME"));
					dangyuan.setDwspsj1(rs1.getString("DY_YBSP"));
					dangyuan.setZzsj(rs1.getString("DY_ZZTIME"));
					dangyuan.setDwspsj2(rs1.getString("DY_ZZSP"));
					dangyuan.setLxfs(rs1.getString("DY_RELATION"));
					dangyuan.setJtzz(rs1.getString("DY_ADDRESS"));
					branch.getPartyMembers().add(dangyuan);
				}
				branchs.add(branch);
			}
			return branchs;
		}catch(Exception e){
			return null;
		}finally {
			ConnectionTool.closeConnection();
		}
		
	
	}

	@Override
	public List<Branch> getBranch2(String branchName,String branchSort) {
		System.out.println(branchName+""+branchSort);
//		String flag="66"+branchName;
		String sql1="SELECT * FROM t_dzb WHERE dept_name=? AND dept_sort=?";
		String sql2="SELECT * FROM t_dzb WHERE dept_sort=? ORDER BY dept_id";
		String sql3="SELECT * FROM t_dzb  ORDER BY dept_id";
		String sql5="SELECT * FROM t_dzb WHERE dept_name=? ORDER BY dept_id";
		Connection conn;
		PreparedStatement pstm = null ;
		ResultSet rs;
		conn=ConnectionTool.getConn();
	    List<Branch> branchs=new ArrayList<Branch>();
		try {
			if((!branchName.equals("")) && !(branchSort.equals("请选择党组织工作分类"))){
				pstm=conn.prepareStatement(sql1);
				pstm.setString(1, branchName);
				pstm.setString(2, branchSort);
				System.out.println(branchName+"kkkkkkk00");
				
			}else if(branchName.equals("")&& !(branchSort.equals("请选择党组织工作分类"))){
				pstm=conn.prepareStatement(sql2);
				pstm.setString(1, branchSort);
				System.out.println(branchSort+"000000");
				
			}else if(branchName.equals("")&& branchSort.equals("请选择党组织工作分类")){
				pstm=conn.prepareStatement(sql3);
				System.out.println("3333");
			}else if(!branchName.equals("")&& branchSort.equals("请选择党组织工作分类")){
				
				pstm=conn.prepareStatement(sql5);
				pstm.setString(1, branchName);
				System.out.println(branchName+"55555");
			}
			
			rs=pstm.executeQuery();
			while(rs.next()){
			    Branch  branch = new Branch();
				branch.setDept_id(rs.getString("dept_id"));
				branch.setDept_name(rs.getString("dept_name"));
				branch.setDept_upname(rs.getString("dept_upname"));
				branch.setDept_sj(rs.getString("dept_sj"));
				branch.setDept_lxr(rs.getString("dept_lxr"));
				branch.setDept_tel(rs.getString("dept_tel"));
				branch.setDept_sort(rs.getString("dept_sort"));
				System.out.println(branch.getDept_id()+"******");
				String sql4="SELECT * FROM t_dy WHERE dept_id=?";
				PreparedStatement pstm1=conn.prepareStatement(sql4);
				System.out.println(branch.getDept_id());
				
				pstm1.setString(1,branch.getDept_id());
				ResultSet rs1=pstm1.executeQuery();
				
				while(rs1.next()){
					
					Dangyuan dangyuan=new Dangyuan();
					dangyuan.setDyId(rs1.getString("DY_ID"));
					dangyuan.setZbId(rs1.getString("DEPT_ID"));
					dangyuan.setName(rs1.getString("DY_NAME"));
					dangyuan.setSex(rs1.getString("DY_SEX"));
					dangyuan.setJiguan(rs1.getString("DY_NATIVE"));
					dangyuan.setMingzu(rs1.getString("DY_NATION"));
					dangyuan.setSfzhm(rs1.getString("DY_SFZ"));
					dangyuan.setRylb(rs1.getString("DY_SORT"));
					dangyuan.setSqrdsj(rs1.getString("DY_SQTIME"));
					dangyuan.setLwjjfzsj(rs1.getString("DY_JJFZTIME"));
					dangyuan.setBylxr(rs1.getString("DY_LXR"));
					dangyuan.setFzdxsj(rs1.getString("DY_SURE"));
					dangyuan.setRdjxr(rs1.getString("DY_RDJSR"));
					dangyuan.setRdsj(rs1.getString("DY_TIME"));
					dangyuan.setDwspsj1(rs1.getString("DY_YBSP"));
					dangyuan.setZzsj(rs1.getString("DY_ZZTIME"));
					dangyuan.setDwspsj2(rs1.getString("DY_ZZSP"));
					dangyuan.setLxfs(rs1.getString("DY_RELATION"));
					dangyuan.setJtzz(rs1.getString("DY_ADDRESS"));
					branch.getPartyMembers().add(dangyuan);
				}
				branchs.add(branch);
			}
			return branchs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
