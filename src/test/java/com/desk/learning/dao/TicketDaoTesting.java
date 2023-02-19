package com.desk.learning.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.desk.learning.model.TicketModel;


class TicketDaoTesting {

	@Test
	public void testOpenConnection() throws Exception{
		System.out.println("open connection");
		Connection result = new TicketDao().getConnection();
		assertEquals(true, result != null);
	}
	
	@Test
	public void testInsertUser() {
//		Integer id = 1;
		Integer ticket_id = 1;
		String name = "badri";
		String medium = "email";
		String priority = "low";
		String email = "badri@gmail.com";
		Long phone = (long) 987654321;
		
		TicketModel t1 = new TicketModel(ticket_id, name, priority, medium, email, phone);
		
		boolean t2 = new TicketDao().insertUser(t1);
		
		assertEquals(true, t2);
	}

}
