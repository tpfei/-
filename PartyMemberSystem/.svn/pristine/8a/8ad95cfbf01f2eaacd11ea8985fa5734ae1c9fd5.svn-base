package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.bean.Branch;
import org.lanqiao.dao.BranchDao;
import org.lanqiao.dao.impl.BranchDaoImpl;
import org.lanqiao.service.BranchService;
import org.lanqiao.util.PageModel;

public class BranchServicrImpl implements BranchService {

	BranchDao branchDao;

	public BranchServicrImpl() {
		branchDao = new BranchDaoImpl();
	}

	public boolean deleteBranch(String branchId) {
		// TODO Auto-generated method stub
		return branchDao.deleteBranch(branchId);
	}

	public PageModel<Branch> getBranch(int currentPage, String deptName) {
		// TODO Auto-generated method stub
		return branchDao.getBranch(currentPage, deptName);
	}

	public boolean saveBranch(Branch branch) {
		return branchDao.saveBranch(branch);
	}

	public PageModel<Branch> getAllBranch(int currentPage) {
		return branchDao.getAllBranch(currentPage);
	}

	public Branch getBranchById(String dept_id) {
		return branchDao.getBranchById(dept_id);
	}

	public boolean updateBranch(Branch branch) {
		return branchDao.updateBranch(branch);
	}

	@Override
	public List<Branch> getAllBranch2() {
		// TODO Auto-generated method stub
		return branchDao.getAllBranch2();
	}

	@Override
	public List<Branch> getBranch2(String branchName, String branchSort) {
		// TODO Auto-generated method stub
		return branchDao.getBranch2(branchName, branchSort);
	}

}
