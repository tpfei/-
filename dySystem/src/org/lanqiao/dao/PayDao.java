package org.lanqiao.dao;

import org.lanqiao.bean.Pay;
import org.lanqiao.util.PageModel2;

public interface PayDao {
	PageModel2<Pay> showPay(int currentPageNo,int rows);
	void delPay();
	int updatePay(String dy_id);
	void addPay();
	
}
