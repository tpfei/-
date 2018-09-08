package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.bean.Dangyuan;
import org.lanqiao.dao.DangyuanDao;
import org.lanqiao.dao.impl.DangyuanDaoImpl;
import org.lanqiao.service.DangyuanService;

public class DangyuanServiceImpl implements DangyuanService{
	DangyuanDao dangyuanDao;
	public DangyuanServiceImpl()
	{
		dangyuanDao=new DangyuanDaoImpl();
	}
	public List<Dangyuan> getAllDangyuan() {
		return dangyuanDao.getAllDangyuan();
	}

	public int saveDangyuan(Dangyuan dangyuan) {
		return dangyuanDao.saveDangyuan(dangyuan);
	}

	public int deleteDangyuan(String  sfzhm) {
		return dangyuanDao.deleteDangyuan(sfzhm);
	}
	public Dangyuan selectDangyuan(String dyName) {
		return dangyuanDao.selectDangyuan(dyName);
	}
	public void out(String dyName, String NewZbName) {
		dangyuanDao.out(dyName, NewZbName);
	}
	public boolean del(String sfzid) {
		return dangyuanDao.del(sfzid);
	}
	@Override
	public int updateDangyuan(Dangyuan dangyuan) {
		return dangyuanDao.updateDangyuan(dangyuan);
	}
	
	public Dangyuan viewDangyuan(String dyName,String sfzhm){
		return dangyuanDao.viewDangyuan(dyName,sfzhm);	
	}
}
