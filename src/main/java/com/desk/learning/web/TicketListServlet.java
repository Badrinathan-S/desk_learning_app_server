package com.desk.learning.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desk.learning.dao.TicketDao;
import com.desk.learning.model.TicketModel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TicketListServlet
 */
//@WebServlet("/TicketListServlet")
public class TicketListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketDao ticketDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	ticketDao = new TicketDao();
    }

	/**x`
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOptions(request, response);
		PrintWriter out = response.getWriter();
		ArrayList<TicketModel> ticketList = (ArrayList<TicketModel>) ticketDao.getTickets();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(ticketList);
		out.write(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(request, response);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
		response.setHeader("Allow", "GET, HEAD, POST, TRACE, OPTIONS");
		response.setContentType("application/json");
	}

}
