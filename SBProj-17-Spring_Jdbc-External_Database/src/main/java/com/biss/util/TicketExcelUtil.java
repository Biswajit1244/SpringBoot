package com.biss.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.biss.model.Ticket;

@Component
public class TicketExcelUtil {
	public List<Ticket> readFromExcel(){
		List<Ticket> listTic=null;
		try {
			listTic=new ArrayList<Ticket>();
			//1.Create Workbook
			Workbook book=new XSSFWorkbook(new File("G:\\excel\\Tickets.xlsx"));
			//2.Read Sheet from the Workbook 
			Sheet s=book.getSheet("TICKET");
			//3.Read row
			Iterator<Row> itr=s.iterator();
			while (itr.hasNext()) {
				Row r = itr.next();
				listTic.add(new Ticket(
						(int)r.getCell(0).getNumericCellValue(),
						(int)r.getCell(1).getNumericCellValue(),
						(float)r.getCell(2).getNumericCellValue(),
						(float)r.getCell(3).getNumericCellValue()));
			}
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTic;
	}
	public boolean saveDBtoExcel(List<Ticket> list) {
		boolean flag=false;
		try {
			Workbook book=new XSSFWorkbook();
			//2. create new Sheet
			Sheet s=book.createSheet("Tickets");
			//3. Create Head and Body
			setHead(s);
			setBody(s,list);
			//4. write to one file
			book.write(new FileOutputStream("G:\\excel\\OutTickets.xlsx"));
			flag=true;
			book.close();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	private void setHead(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("TICKETID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("FARE");
		r.createCell(3).setCellValue("GST");
		r.createCell(4).setCellValue("TOTAL");
	}
	private void setBody(Sheet s, List<Ticket> list) {
		Row r=null;
		int count=1;
		for(Ticket tc:list) {
			r=s.createRow(count++);
			r.createCell(0).setCellValue(tc.getTickId());
			r.createCell(1).setCellValue(tc.getCode());
			r.createCell(2).setCellValue(tc.getFare());
			r.createCell(3).setCellValue(tc.getGst());
			r.createCell(4).setCellValue(tc.getTotal());
		}
	}
}	
