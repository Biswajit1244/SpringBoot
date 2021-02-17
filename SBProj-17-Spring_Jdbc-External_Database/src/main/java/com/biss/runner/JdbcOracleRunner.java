package com.biss.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.biss.model.Ticket;
import com.biss.service.ITicketService;
import com.biss.util.TicketExcelUtil;

@Component
public class JdbcOracleRunner implements CommandLineRunner {
	@Autowired
	ITicketService serv;
	@Autowired
	TicketExcelUtil util;
	@Override
	public void run(String... args) throws Exception {
//		//Insert Data
//		Ticket t=new Ticket();
//		t.setTickId(104);
//		t.setCode(6598);
//		t.setFare(752.23f);
//		t.setGst(18.0f);
//		int c=serv.bookTicket(t);
//		if(c>0) {
//			System.out.println("Record Inserted");
//		}else {
//			System.out.println("Insertion Failed");
//		}
		
//		//Update Data
//		Ticket t=new Ticket();
//		t.setTickId(101);
//		t.setGst(18.0f);
//		t.setFare(1032.23f);
//		int c=serv.updateTicket(t);
//		if(c>0) {
//			System.out.println("Updated");
//		}else {
//			System.out.println("Update Failed");
//		}
		
//		//Delete Record
//		int c=serv.deleteTicket(102);
//		if(c>0) {
//			System.out.println("Delete");
//		}else {
//			System.out.println("Delete failed");
//		}
		
//		//Fetch Data
//		System.out.println(serv.getOneTicketDetails(104));
		
//		//Get All Ticket Details
//		List<Ticket> list=serv.getAllTicket();
//		list.forEach(System.out::println);
		
//		//Batch Insert
//		serv.groupTicketBooking(Arrays.asList(
//				new Ticket(105, 6563, 653.0f, 18.0f),
//				new Ticket(106, 6953, 786.0f, 18.0f),
//				new Ticket(107, 8564, 865.0f, 18.0f),
//				new Ticket(108, 6903, 600.0f, 18.0f)
//				));
		
//		//Excel to Database
//		List<Ticket> list=util.readFromExcel();
//		serv.groupTicketBooking(list);
//		System.out.println("done");
		
		//Read Data from Table and Convert to Excel file
		util.saveDBtoExcel(serv.getAllTicket());
		System.out.println("Done");
	}
}
