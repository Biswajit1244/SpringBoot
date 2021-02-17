package com.biss.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.biss.mapper.TicketMapper;
import com.biss.model.Ticket;
@Repository
public class TicketDaoImpl implements ITicketDao {
	@Autowired
	JdbcTemplate jt;
	
	@Override
	public int bookTicket(Ticket tk) {
		String sql="INSERT INTO TICKET VALUES(?,?,?,?,?)";
		int count=jt.update(sql, tk.getTickId(),tk.getCode(),tk.getFare(),
						tk.getGst(),tk.getTotal());
		return count;
	}

	@Override
	public int updateTicket(Ticket tk) {
		String sql="UPDATE TICKET SET FARE=?,TOTAL=? WHERE TICKETID=?";
		int count=jt.update(sql, tk.getFare(),tk.getTotal(),tk.getTickId());
		return count;
	}

	@Override
	public int deleteTicket(Integer tkid) {
		String sql="DELETE FROM TICKET WHERE TICKETID=?";
		int count=jt.update(sql, tkid);
		return count;
	}
	@Override
	public Ticket getOneTicketDetails(Integer tkid) {
		String sql="SELECT * FROM TICKET WHERE TICKETID=?";
		Ticket tic=jt.queryForObject(sql,(rs,count)->{
			Ticket t=new Ticket();
			t.setTickId(rs.getInt(1));
			t.setCode(rs.getInt(2));
			t.setFare(rs.getFloat(3));
			t.setGst(rs.getFloat(4));
			t.setTotal(rs.getFloat(5));
			return t;
		},tkid);
		return tic;
	}
	@Override
	public List<Ticket> getAllTicket() {
		String sql="SELECT * FROM TICKET";
		List<Ticket> list=jt.query(sql, (rs,count)->{
			Ticket t=new Ticket();
			t.setTickId(rs.getInt(1));
			t.setCode(rs.getInt(2));
			t.setFare(rs.getFloat(3));
			t.setGst(rs.getFloat(4));
			t.setTotal(rs.getFloat(5));
			return t;
		});
		return list;
	}
	@Override
	public int[] groupTicketBooking(List<Ticket> list) {
		String sql="INSERT INTO TICKET VALUES(?,?,?,?,?)";
		List<Object[]> listObj=list.stream().map(t->
				new Object[]{t.getTickId(),t.getCode(),t.getFare(),
							 t.getGst(),t.getTotal()})
					.collect(Collectors.toList());
			int[] cp=jt.batchUpdate(sql,listObj);
		return cp;
	}
}
