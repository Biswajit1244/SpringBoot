package com.biss.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.biss.model.Ticket;

public class TicketMapper implements RowMapper<Ticket> {

	@Override
	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ticket t=new Ticket();
		t.setTickId(rs.getInt(1));
		t.setCode(rs.getInt(2));
		t.setFare(rs.getFloat(3));
		t.setGst(rs.getFloat(4));
		t.setTotal(rs.getFloat(5));
		return t;
	}

}
