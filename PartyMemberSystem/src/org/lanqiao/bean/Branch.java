package org.lanqiao.bean;

import java.util.ArrayList;
import java.util.List;

public class Branch {
	private String dept_id;
	private String dept_name;
	private String dept_upname;
	private String dept_sj;
	private String dept_lxr;
	private String dept_tel;
	private String dept_sort;
	private List<Dangyuan> partyMembers =new ArrayList<>();
	public List<Dangyuan> getPartyMembers() {
		return partyMembers;
	}
	public void setPartyMembers(List<Dangyuan> partyMembers) {
		this.partyMembers = partyMembers;
	}
	@Override
	public String toString() {
		return "Branch [dept_id=" + dept_id + ", dept_name=" + dept_name + ", dept_upname=" + dept_upname + ", dept_sj="
				+ dept_sj + ", dept_lxr=" + dept_lxr + ", dept_tel=" + dept_tel + ", dept_sort=" + dept_sort + "]";
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_upname() {
		return dept_upname;
	}
	public void setDept_upname(String dept_upname) {
		this.dept_upname = dept_upname;
	}
	public String getDept_sj() {
		return dept_sj;
	}
	public void setDept_sj(String dept_sj) {
		this.dept_sj = dept_sj;
	}
	public String getDept_lxr() {
		return dept_lxr;
	}
	public void setDept_lxr(String dept_lxr) {
		this.dept_lxr = dept_lxr;
	}
	public String getDept_tel() {
		return dept_tel;
	}
	public void setDept_tel(String dept_tel) {
		this.dept_tel = dept_tel;
	}
	public String getDept_sort() {
		return dept_sort;
	}
	public void setDept_sort(String dept_sort) {
		this.dept_sort = dept_sort;
	}
	
}
