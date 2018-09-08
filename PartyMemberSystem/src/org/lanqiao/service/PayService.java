package org.lanqiao.service;

import org.lanqiao.bean.Pay;
import org.lanqiao.util.PageModel2;

public interface PayService {
	PageModel2<Pay> viewPay(int currentPageNo,int rows);

	int updateRole(String dy_id);
}
