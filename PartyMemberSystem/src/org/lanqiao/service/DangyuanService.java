package org.lanqiao.service;

import java.util.List;

import org.lanqiao.bean.Dangyuan;

public interface DangyuanService {
	public List<Dangyuan>getAllDangyuan();
	public int saveDangyuan(Dangyuan dangyuan);
	public int deleteDangyuan(String sfzhm);
	public Dangyuan selectDangyuan(String dyName);
	public void out(String dyName,String NewZbName);
	public boolean del(String sfzid);
	public int updateDangyuan(Dangyuan dangyuan) ;
	public Dangyuan viewDangyuan(String dyName,String sfzhm);
	
}
