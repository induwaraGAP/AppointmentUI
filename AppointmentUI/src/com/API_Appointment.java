package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AppointmentBean;
import model.Appointment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class API_Appointment
 */
@WebServlet("/API_Appointment")
public class API_Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public API_Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentBean appbean = new AppointmentBean();
		appbean.setCheckedStatus("No");
		appbean.setTokenNumber(56);
		//check whether this is for another patient
		if(request.getParameter("AnotherBook") == null) {
			appbean.setAnotherPatientStatus("No");
		}else {
			appbean.setAnotherPatientStatus("Yes");
		}
		appbean.setAnotherPatientNIC(request.getParameter("AnotherPatientNIC"));
		appbean.setAnotherPatientName(request.getParameter("AnotherPatientName"));
		appbean.setAnotherPatientEmail(request.getParameter("AnotherPatientEmail"));
		appbean.setAnotherPatientContactNumber(request.getParameter("AnotherPatientContactNumber"));
		appbean.setD_ID(Integer.parseInt(request.getParameter("d_ID")));
		appbean.setSheduleID(Integer.parseInt(request.getParameter("ScheduleID")));
		appbean.setHospitalID(Integer.parseInt(request.getParameter("HospitalID")));
		appbean.setBookedDate(request.getParameter("BookedDate"));
		appbean.setPaymentType(request.getParameter("PaymentType"));
		System.out.println("this is payment type "+request.getParameter("PaymentType"));
		appbean.setPatientID(Integer.parseInt(request.getParameter("PatientID")));
		appbean.setAmount(Double.parseDouble(request.getParameter("Amount")));
		
		
		Appointment app = new Appointment();
		String output = app.insertAppointment(appbean); 
		System.out.println("finished it");
		response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request); 
		System.out.println("this is para " + paras);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
	
	String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}


}
