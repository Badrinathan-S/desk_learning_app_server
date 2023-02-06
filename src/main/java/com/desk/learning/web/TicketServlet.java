package com.desk.learning.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.desk.learning.dao.TicketDao;
import com.desk.learning.model.MessageModel;
import com.desk.learning.model.TicketModel;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TicketServlet
 */
//@WebServlet("/TicketServlet")
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TicketDao ticketDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		ticketDao = new TicketDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String primaryId = request.getParameter("primaryId") ;
		PrintWriter out = response.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer id = Integer.parseInt(primaryId);
			TicketModel ticket = ticketDao.getTicket(id);
			ticketDao.insertUser(ticket);
			String jsonString = mapper.writeValueAsString(ticket);
			response.setStatus(200);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(jsonString);
		} catch (JSONException e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);

		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stubPrintWriter out = response.getWriter();
		doOptions(request, response);
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer id = json.getInt("id");
			String name = json.getString("name");
			String priority = json.getString("priority");
			String medium = json.getString("medium");
			String email = json.getString("email");
			Long phone = json.getLong("phone");
			TicketModel ticket = new TicketModel(id, name, priority, medium, email, phone);
			ticketDao.insertUser(ticket);
			MessageModel message = new MessageModel("Ticket Created");
			String jsonString = mapper.writeValueAsString(message);
			response.setStatus(200);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(jsonString);
		} catch (JSONException e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);

		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOptions(request, response);
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer primaryId = json.getInt("primaryId");
			Integer id = json.getInt("id");
			String name = json.getString("name");
			String priority = json.getString("priority");
			String medium = json.getString("medium");
			String email = json.getString("email");
			Long phone = json.getLong("phone");
			TicketModel ticket = new TicketModel(primaryId, id, name, priority, medium, email, phone);
			boolean isUpdated  = ticketDao.updateTicket(ticket);
			if(isUpdated) {
				MessageModel message = new MessageModel("Ticket Updated");
				String jsonString = mapper.writeValueAsString(message);
				response.setStatus(200);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(jsonString);
			}
			else {
				throw new Exception();
			}
		} catch (JSONException e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);

		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);
		}
		
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject(request.getReader().lines().collect(Collectors.joining()));
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer primaryId = json.getInt("primaryId");
			Integer id = json.getInt("id");
			boolean isUpdated  = ticketDao.deleteTicket(primaryId, id);
			if(isUpdated) {
				MessageModel message = new MessageModel("Ticket deleted");
				String jsonString = mapper.writeValueAsString(message);
				response.setStatus(200);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(jsonString);
			}
			else {
				throw new Exception();
			}
		} catch (JSONException e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);

		} catch (Exception e) {
			System.out.println(e);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(400);
			String jsonString = mapper.writeValueAsString(e);
			out.write(jsonString);
		}
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
