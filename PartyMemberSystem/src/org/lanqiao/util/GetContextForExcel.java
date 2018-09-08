package org.lanqiao.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.lanqiao.bean.Dangyuan;

import oracle.net.aso.d;

public class GetContextForExcel {
	public static List<Dangyuan> getDangyuans(String filePath) {
		List<Dangyuan> dangyuans = new ArrayList<Dangyuan>();

		
		XSSFWorkbook book;
		try {
			book = new XSSFWorkbook(filePath);
			XSSFSheet sheet = book.getSheetAt(0);

			/**
			 * 通常第一行都是标题，所以从第二行开始读取数据
			 */
			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				XSSFRow row = sheet.getRow(i);
				row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(12).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(13).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(14).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(15).setCellType(Cell.CELL_TYPE_STRING);
				row.getCell(16).setCellType(Cell.CELL_TYPE_STRING);
				String name = row.getCell(0).getStringCellValue(); // 姓名
				String sex = row.getCell(1).getStringCellValue(); // 性别
				String jiguan = row.getCell(2).getStringCellValue();// 籍贯
				String mingzu = row.getCell(3).getStringCellValue(); // 民族
				String sfzhm = row.getCell(4).getStringCellValue();// 身份证号
				String dealerrylbName = row.getCell(5).getStringCellValue(); // 人员类别
				String zbName = row.getCell(6).getStringCellValue(); // 所在支部
				String sqrdsj = row.getCell(7).getStringCellValue(); // 申请入党时间
				String lwjjfzsj = row.getCell(8).getStringCellValue(); // 列为积极分子时间
				String bylxr = row.getCell(9).getStringCellValue();// 培养联系人
				String fzdxsj = row.getCell(10).getStringCellValue(); // 确定为发展对象支部大会时间
				String rdjxr = row.getCell(11).getStringCellValue(); // 入党介绍人
				String dwspsj1 = row.getCell(12).getStringCellValue(); // (预备)党委审批时间
				String zzsj = row.getCell(13).getStringCellValue(); // 支部大会讨论预备党员转正日期
				String dwspsj2 = row.getCell(14).getStringCellValue(); // (转正)党委审批时间
				String lxfs = row.getCell(15).getStringCellValue();// 联系方式
				String jtzz = row.getCell(16).getStringCellValue(); // 家庭地址
//				String dealerName = row.getCell(17).getStringCellValue();// 入党介绍人
				// String dealerName = row.getCell(18).getStringCellValue();
				Dangyuan dangyuan = new Dangyuan();
				dangyuan.setDyId(UUID.randomUUID().toString());
				dangyuan.setZbId(zbName);
				dangyuan.setName(name);
				dangyuan.setSex(sex);
				dangyuan.setJiguan(jiguan);
				dangyuan.setMingzu(mingzu);
				dangyuan.setSfzhm(sfzhm);
				dangyuan.setRylb(dealerrylbName);
//				dangyuan.setZbName(zbName);
				dangyuan.setSqrdsj(sqrdsj);
				dangyuan.setLwjjfzsj(lwjjfzsj);
				dangyuan.setBylxr(bylxr);
				dangyuan.setFzdxsj(fzdxsj);
				dangyuan.setRdjxr(rdjxr);
				dangyuan.setDwspsj1(dwspsj1);
				dangyuan.setZzsj(zzsj);
				dangyuan.setDwspsj2(dwspsj2);
				dangyuan.setLxfs(lxfs);
				dangyuan.setJtzz(jtzz);
				dangyuans.add(dangyuan);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Dangyuan shipment : dangyuans) {
			System.out.println(shipment.getName());
		}
		return dangyuans;
	}
}
