package org.lanqiao.service.impl;

import org.lanqiao.bean.Pay;
import org.lanqiao.dao.PayDao;
import org.lanqiao.dao.impl.PayDaoImpl;
import org.lanqiao.service.PayService;
import org.lanqiao.util.PageModel;
import org.lanqiao.util.PageModel2;

public class PayServiceImpl implements PayService{
	PayDao payDao;

	@Override
	public PageModel2<Pay> viewPay(int currentPageNo,int rows) {
		payDao = new PayDaoImpl();
		System.out.println("hahahahha");
		return payDao.showPay(currentPageNo,rows);
		
	}

	@Override
	public int updateRole(String dy_id) {
		payDao = new PayDaoImpl();
		return payDao.updatePay(dy_id);
	}
	
}
