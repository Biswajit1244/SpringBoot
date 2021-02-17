package com.biss.service;

import java.util.List;

import com.biss.model.Ticket;

public interface ITicketService {
	public int bookTicket(Ticket tk);
	public int updateTicket(Ticket tk);
	public int deleteTicket(Integer tkid);
	
	public Ticket getOneTicketDetails(Integer tkid);
	public List<Ticket> getAllTicket();
	
	public int[] groupTicketBooking(List<Ticket> list);
}
