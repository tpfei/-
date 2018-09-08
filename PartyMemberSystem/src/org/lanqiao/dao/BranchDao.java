package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.bean.Branch;
import org.lanqiao.util.PageModel;

public interface BranchDao {
	
	public PageModel<Branch> getAllBranch(int currentPage);
	public Branch getBranchById(String dept_id);
	
	public PageModel<Branch> getBranch(int currentPage,String deptName);
	
	
	
	
	//************ÐÂ°æ******
	public List<Branch> getAllBranch2();
	public List<Branch> getBranch2(String branchName,String branchSort );
	public boolean deleteBranch(String branchId);
	public boolean saveBranch(Branch branch);
	public boolean updateBranch(Branch branch);
	
}
