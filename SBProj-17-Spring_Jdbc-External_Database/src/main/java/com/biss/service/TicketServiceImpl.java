package com.biss.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biss.dao.ITicketDao;
import com.biss.model.Ticket;

@Service
public class TicketServiceImpl implements ITicketService {
	@Autowired
	ITicketDao dao;
	@Override
	public int bookTicket(Ticket tk) {
		tk.setTotal(tk.getFare()+(tk.getFare()*tk.getGst())/100);
		return dao.bookTicket(tk);
	}

	@Override
	public int updateTicket(Ticket tk) {
		tk.setTotal(tk.getFare()+(tk.getFare()*tk.getGst())/100);
		return dao.updateTicket(tk);
	}

	@Override
	public int deleteTicket(Integer tkid) {	
		return dao.deleteTicket(tkid);
	}

	@Override
	public Ticket getOneTicketDetails(Integer tkid) {
		return dao.getOneTicketDetails(tkid);
	}

	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> list=dao.getAllTicket();
		list=list.stream()
			.sorted((o1,o2)->o1.getTickId()-o2.getTickId())
			.collect(Collectors.toList());
		return list;
	}
	@Override
	public int[] groupTicketBooking(List<Ticket> list) {
		list.stream().map(t->{t.setTotal(t.getFare()+(t.getFare()*t.getGst())/100);
			return t;
			}).collect(Collectors.toList());
		
		return dao.groupTicketBooking(list);
	}

}
