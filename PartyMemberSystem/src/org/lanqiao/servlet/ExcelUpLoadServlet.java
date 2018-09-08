package org.lanqiao.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.bean.Dangyuan;
import org.lanqiao.service.DangyuanService;
import org.lanqiao.service.impl.DangyuanServiceImpl;
import org.lanqiao.util.GetContextForExcel;
import org.lanqiao.util.TransactionManager;

/**
 * Servlet implementation class ExcelUpLoadServlet
 */
@WebServlet("/ExcelUpLoadServlet")
public class ExcelUpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelUpLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aaa");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		boolean isMultipart=ServletFileUpload.isMultipartContent(request);
		//上传文件存储路径
		String uploadFilePath = request.getSession().getServletContext().getRealPath("WEB-INF/file/");
//		System.out.println("sss");
		if (isMultipart) {
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
			String filePath = null ;
			fileUpload.setSizeMax(1024*1024*50);
			try {
				List<FileItem> list  = fileUpload.parseRequest(request);
				System.out.println(list.size());
				for (FileItem fileItem : list) {
					if (fileItem.isFormField()) {
						String name = fileItem.getName();
						String value = fileItem.getString();
						System.out.println(name + ":" + value);
					}else {
						System.out.println("success");
//						String fieldName = fileItem.getFieldName();
						String fileName = fileItem.getName();
						filePath = uploadFilePath +"/"+ fileName;
						if (fileName!=null && !fileName.equals("")) {
							File savaFile = new File(uploadFilePath, fileName);
							fileItem.write(savaFile);
						}
					}
				}
				System.out.println(filePath);
				List<Dangyuan> dangyuans = GetContextForExcel.getDangyuans(filePath);
				DangyuanService dangyuanService = new TransactionManager<DangyuanService>().createProxy(new DangyuanServiceImpl());
				
				for (Dangyuan dangyuan : dangyuans) {
					dangyuanService.saveDangyuan(dangyuan);
					System.out.println(dangyuan);
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
