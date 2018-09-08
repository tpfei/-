package org.lanqiao.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.lanqiao.bean.Dangyuan;
import org.lanqiao.service.BranchService;
import org.lanqiao.service.DangyuanService;
import org.lanqiao.service.impl.BranchServicrImpl;
import org.lanqiao.service.impl.DangyuanServiceImpl;
import org.lanqiao.util.TransactionManager;

import com.google.gson.Gson;

public class DangyuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DangyuanServlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int lastIndex=uri.lastIndexOf("/");
		uri=uri.substring(lastIndex+1);
		if ("downDYMessage.do".equals(uri)) {
			response.addHeader("Content-Type", "application/octet-stream");
			String fileName = "党员信息采集表.xlsx";
			response.setHeader("Content-Disposition",  "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/file/"+"DangYuanMessage.xlsx");
			OutputStream out = response.getOutputStream();
			byte [] buffer = new byte[1024];
			int len = 0;
			
			while((len = is.read(buffer)) != -1){
				out.write(buffer, 0, len);
			}
			
			is.close();
		}
//		if ("saveDangyuanForPOI.do".equals(uri)) {
//			System.out.println("sss");
		
//		}
		if ("outDangyuan.do".equals(uri)) {
			String fileUri = getServletContext().getRealPath("/WEB-INF/file/"+"党员名册.xlsx");
			
			System.out.println(fileUri);
			DangyuanService dangyuanService = new TransactionManager<DangyuanService>()
					.createProxy(new DangyuanServiceImpl());
			List<Dangyuan> allDangyuan = dangyuanService.getAllDangyuan();
			// 定义表头
			String[] title = { "党员id", "姓名", "身份证号码","性别","民族","入党日期","人员类别","所在党支部","联系方式" };
			// 创建excel工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 创建工作表sheet
			XSSFSheet sheet = workbook.createSheet();
			// 创建第一行
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = null;
			// 插入第一行数据的表头
			for (int i = 0; i < title.length; i++) {
				cell = row.createCell(i);
				cell.setCellValue(title[i]);
			}
			int m=0;
			// 写入数据
			for (int i = 1; i <= allDangyuan.size(); i++,m++) {
				XSSFRow nrow = sheet.createRow(i);
				XSSFCell ncell = nrow.createCell(0);
				ncell.setCellValue(allDangyuan.get(m).getDyId());
				ncell = nrow.createCell(1);
				ncell.setCellValue(allDangyuan.get(m).getName());
				ncell = nrow.createCell(2);
				ncell.setCellValue(allDangyuan.get(m).getSfzhm());
				ncell = nrow.createCell(3);
				ncell.setCellValue(allDangyuan.get(m).getSex());
				ncell = nrow.createCell(4);
				ncell.setCellValue(allDangyuan.get(m).getMingzu());
				ncell = nrow.createCell(5);
				ncell.setCellValue(allDangyuan.get(m).getZzsj());
				ncell = nrow.createCell(6);
				ncell.setCellValue(allDangyuan.get(m).getRylb());
				ncell = nrow.createCell(7);
				ncell.setCellValue(allDangyuan.get(m).getZbId());
				ncell = nrow.createCell(8);
				ncell.setCellValue(allDangyuan.get(m).getLxfs());
			}
			// 创建excel文件
			File file = new File(fileUri);
			try {
				file.createNewFile();
				// 将excel写入
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String fileName = "党员名册.xlsx";
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			InputStream is = getServletContext().getResourceAsStream("/WEB-INF/file/" + fileName);
			OutputStream out = response.getOutputStream();
			byte[] b= new byte[1024];
			int len = 0 ;
			while ((len = is.read(b))!=-1) {
				out.write(b,0,len);
			}
			out.close();
			is.close();
 		}
		if("viewDangyuan.do".equals(uri))
		{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
//			System.out.println(request.getParameter("dzbId"));
//			if (request.getParameter("dzbId")!=null) {
//				System.out.println("ssss");
//				request.getRequestDispatcher("page/dyxx.html").forward(request, response);
//			}
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			List<Dangyuan> allDangyuan=dangyuanService.getAllDangyuan();
			
			Gson gson=new Gson();
			String dangyuanData=gson.toJson(allDangyuan);
			
			PrintWriter out=response.getWriter();
			out.write(dangyuanData);
			out.flush();
		}
		if("deleteDangyuan.do".equals(uri))
		{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			String sfzhm=request.getParameter("sfzhm");
			int fl=dangyuanService.deleteDangyuan(sfzhm);
			if(fl==1) System.out.println("----删除成功---");
			else System.out.println("----删除失败---");
		}
		if("selectDangyuan.do".equals(uri))
		{	
			System.out.println("--------------------------");
			
			response.setContentType("application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			String dyName=request.getParameter("dyName");
			System.out.println("sss" + dyName);
			Dangyuan dangyuan=new Dangyuan();
			dangyuan=dangyuanService.selectDangyuan(dyName);
			
			Gson gson=new Gson();
			String dangyuanData=gson.toJson(dangyuan);
			System.out.println("___________"+dangyuanData);
			PrintWriter out=response.getWriter();
			out.write(dangyuanData);
			out.flush();
		}
		if("saveDangyuan.do".equals(uri))
		{
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			Dangyuan dangyuan=new Dangyuan();
			String dangyuanStr=request.getParameter("dyMessage");
			System.out.println(dangyuanStr);
			Gson gson=new Gson();
			dangyuan=gson.fromJson(dangyuanStr, Dangyuan.class);
			int fl=dangyuanService.saveDangyuan(dangyuan);
			if(fl==1) System.out.println("保存成功");
			else System.out.println("保存失败");
		} if("out.do".equals(uri)){
        	DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			Dangyuan dangyuan=new Dangyuan();
			String DyName=request.getParameter("name");
			String NewZbName=request.getParameter("NewZbName");
			System.out.println(DyName + NewZbName);
			dangyuanService.out(DyName,NewZbName);
        }
		if ("deleteNewDeptName.do".equals(uri)) {
			String id = request.getParameter("id");
			System.out.println(id);
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			boolean check = dangyuanService.del(id);
			if (check) {
				request.getRequestDispatcher("viewDangyuan.do").forward(request, response);
			}
			
		}
		if("updateDangyuan.do".equals(uri))
		{
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			Dangyuan dangyuan=new Dangyuan();
			String dangyuanStr=request.getParameter("dyMessage");//dyMessage为前端传过来的数据名称
			System.out.println("+++++++++++++++++++修改后"+dangyuanStr);
			Gson gson=new Gson();
			dangyuan=gson.fromJson(dangyuanStr, Dangyuan.class);
			int fl=dangyuanService.updateDangyuan(dangyuan);
			if(fl==1) System.out.println("更改成功");
			else System.out.println("更改失败");
		}
		if("chaxun.do".equals(uri)){
        	String dyName=request.getParameter("dyName");
        	String sfzhm=request.getParameter("sfzhm");
        	DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
            Dangyuan dangyuan=dangyuanService.viewDangyuan(dyName,sfzhm);
            if(dangyuan!=null){
            	response.setContentType("application/json");
    			response.setCharacterEncoding("UTF-8");
            	Gson gson=new Gson();
                String dangyuanData=gson.toJson(dangyuan);
                PrintWriter out=response.getWriter();
                out.write(dangyuanData);
                out.flush();
            }     
        }
	 if("chakanDangyuan.do".equals(uri)){	    
        	//SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	//Date date=new Date();
        	
        	//System.out.println("当前时间"+a.format(date));
        	response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			DangyuanService dangyuanService=new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
			List<Dangyuan> allDangyuan=dangyuanService.getAllDangyuan();	
			BranchService branchService = new TransactionManager<BranchService>().createProxy(new BranchServicrImpl());
			System.out.println(allDangyuan);
			for(int i=0;i<allDangyuan.size();i++){
				String Dept_name;
				if(allDangyuan.get(i).getZbId()==null||"".equals(allDangyuan.get(i).getZbId())){
					Dept_name="";
				}else{
					Dept_name=branchService.getBranchById(allDangyuan.get(i).getZbId()).getDept_name();
				}
			
			allDangyuan.get(i).setZbName(Dept_name);
			//System.out.println("遍历"+allDangyuan.get(i).getOutTime());
			}
		
			List<Dangyuan> all=new ArrayList<Dangyuan>();
			for(int i=0;i<allDangyuan.size();i++)
			{		
				//System.out.println(allDangyuan.get(i).getNewZbName());
			if(allDangyuan.get(i).getNewZbName()!=null){
				all.add(allDangyuan.get(i));
			}
        }
			Gson gson=new Gson();
			String dangyuanData=gson.toJson(all);			
			PrintWriter out=response.getWriter();
			out.write(dangyuanData);
			out.flush();		
		} 	
       
    
}
        
	}


