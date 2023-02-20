package com.desk.learning.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.desk.learning.model.TicketModel;


class TicketDaoTesting {

	TicketDao ticketDao;
	
	@BeforeEach
	public void setup() throws SQLException {
		ticketDao = mock(TicketDao.class);
		System.out.println("mock testing");
	}

	@Test
	public void testOpenConnection() throws Exception{
		Connection result = ticketDao.getConnection();
		assertEquals(true, result==null);
	}
	
	@Test
	public void testInsertUser() {
		Integer ticket_id = 1;
		String name = "nathan";
		String medium = "email";
		String priority = "low";
		String email = "badri@gmail.com";
		Long phone = (long) 987654321;
		TicketModel t1 = new TicketModel(ticket_id, name, priority, medium, email, phone);
		boolean t2 = ticketDao.insertUser(t1);
		when(ticketDao.insertUser(t1)).thenReturn(true);
		assertEquals(true, ticketDao.insertUser(t1));
	}

}
