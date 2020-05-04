package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import beans.AppointmentBean;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import util.DBConnection;

public class Appointment {

	public String output;
	private Connection con;
	private String query;
	private PreparedStatement preparedStmt;
	private int LastAppointmentID;

	// select all the appointment from database
	public String readAppointment() {
		output = "";
		AppointmentBean appBeanRead = new AppointmentBean();
		try {
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'><tr>" +
					"<th>ID </th>" +
					"<th>Patient ID</th>" +
					"<th>Checked Status</th>"+ 
					"<th>Token Number</th>" +
					"<th>Another Patient Status</th>" +
					"<th>Another Patient NIC</th>"+
					"<th>Another Patient Name</th>" +
					"<th>Another Patient Email</th>"+
					"<th>Another Patient Contact Number</th>" +
					"<th>Doctor ID</th>" +
					"<th>Shedule ID</th>"+
					"<th>Hospital ID</th>" + 
					"<th>AddedDate</th>" + 
					"<th>BookedDate</th>" + 
					"<th>Update</th>" +
					"<th>Remove</th>" + 
					"</tr>";

			query = "SELECT * FROM appointment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				appBeanRead.setAppointmentID(rs.getInt("AppointmentID"));
				appBeanRead.setPatientID(rs.getInt("PatientID"));
				appBeanRead.setCheckedStatus(rs.getString("CheckedStatus"));
				appBeanRead.setTokenNumber(rs.getInt("TokenNumber"));
				appBeanRead.setAnotherPatientStatus(rs.getString("AnotherPatientStatus"));
				appBeanRead.setAnotherPatientNIC(rs.getString("AnotherPatientNIC"));
				appBeanRead.setAnotherPatientName(rs.getString("AnotherPatientName"));
				appBeanRead.setAnotherPatientEmail(rs.getString("AnotherPatientEmail"));
				appBeanRead.setAnotherPatientContactNumber(rs.getString("AnotherPatientContactNumber"));
				appBeanRead.setD_ID(rs.getInt("d_ID"));
				appBeanRead.setSheduleID(rs.getInt("SheduleID"));
				appBeanRead.setHospitalID(rs.getInt("HospitalID"));
				appBeanRead.setAddedDate(rs.getString("AddedDate"));
				appBeanRead.setBookedDate(rs.getString("BookedDate"));

				// Add into the HTML table
				output += "<tr><td>" + appBeanRead.getAppointmentID() + "</td>";
				output += "<td>" + appBeanRead.getPatientID() + "</td>";
				output += "<td>" + appBeanRead.getCheckedStatus() + "</td>";
				output += "<td>" + appBeanRead.getTokenNumber() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientStatus() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientNIC() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientName() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientEmail() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientContactNumber() + "</td>";
				output += "<td>" + appBeanRead.getD_ID() + "</td>";
				output += "<td>" + appBeanRead.getSheduleID() + "</td>";
				output += "<td>" + appBeanRead.getHospitalID() + "</td>";
				output += "<td>" + appBeanRead.getAddedDate() + "</td>";
				output += "<td>" + appBeanRead.getBookedDate() + "</td>";
				
				// buttons
				 output += "<td><input name='btnUpdate' type='button' "+
						   " value='Update' "+
						   " class='btnUpdate btn btn-secondary'></td> "+
						   " <td><input name='btnRemove' type='button' "+
						   " value='Remove' "+
						   " class='btnRemove btn btn-danger' data-itemid='"+
						     appBeanRead.getAppointmentID() + "'>" +
						   "</td></tr>"; 
				

			}
			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Appointments";
			System.err.println(e.getMessage());
		}
		return output;
	}

	// to select specific appointment from database
	public String searchAppointment(AppointmentBean appointment) {
		output = "";
		AppointmentBean appBeanRead = new AppointmentBean();
		try {
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr>" + "<th>AppointmentID</th>" + "<th>CheckedStatus</th>"
					+ "<th>TokenNumber</th>" + "<th>Another Patient Status</th>" + "<th>Another Patient NIC</th>"
					+ "<th>Another Patient Name</th>" + "<th>Another Patient Email</th>"
					+ "<th>Another Patient Contact Number</th>" + "<th>d_ID</th>" + "<th>SheduleID</th>"
					+ "<th>HospitalID</th>" + "<th>Added Date</th>" + "<th>Booked Date</th>" + "</tr>";

			query = "SELECT * FROM appointment WHERE AppointmentID = " + appointment.getAppointmentID() + "";
			preparedStmt = con.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				appBeanRead.setAppointmentID(rs.getInt("AppointmentID"));
				appBeanRead.setCheckedStatus(rs.getString("CheckedStatus"));
				appBeanRead.setTokenNumber(rs.getInt("TokenNumber"));
				appBeanRead.setAnotherPatientStatus(rs.getString("AnotherPatientStatus"));
				appBeanRead.setAnotherPatientNIC(rs.getString("AnotherPatientNIC"));
				appBeanRead.setAnotherPatientName(rs.getString("AnotherPatientName"));
				appBeanRead.setAnotherPatientEmail(rs.getString("AnotherPatientEmail"));
				appBeanRead.setAnotherPatientContactNumber(rs.getString("AnotherPatientContactNumber"));
				appBeanRead.setD_ID(rs.getInt("d_ID"));
				appBeanRead.setSheduleID(rs.getInt("SheduleID"));
				appBeanRead.setHospitalID(rs.getInt("HospitalID"));
				appBeanRead.setAddedDate(rs.getString("AddedDate"));
				appBeanRead.setBookedDate(rs.getString("BookedDate"));

				// Add into the HTML table
				output += "<tr><td>" + appBeanRead.getAppointmentID() + "</td>";
				output += "<td>" + appBeanRead.getCheckedStatus() + "</td>";
				output += "<td>" + appBeanRead.getTokenNumber() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientStatus() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientNIC() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientName() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientEmail() + "</td>";
				output += "<td>" + appBeanRead.getAnotherPatientContactNumber() + "</td>";
				output += "<td>" + appBeanRead.getD_ID() + "</td>";
				output += "<td>" + appBeanRead.getSheduleID() + "</td>";
				output += "<td>" + appBeanRead.getHospitalID() + "</td>";
				output += "<td>" + appBeanRead.getAddedDate() + "</td>";
				output += "<td>" + appBeanRead.getBookedDate() + "</td></tr>";

			}
			con.close();

			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Appointments";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String insertAppointment(AppointmentBean appointment) {
		System.out.println("came here 5");
		output = "";
		String validData = "";
		try {
			System.out.println("1");
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
			System.out.println("2");
			// check the validity of data
			validData = validateData(appointment);
			if (!validData.equals("good")) {
				System.out.println(validData);
				return validData;
			}
			System.out.println("3");
			// create a prepared statement
			query = "INSERT INTO appointment ( CheckedStatus, TokenNumber, AnotherPatientStatus, AnotherPatientNIC, AnotherPatientName, AnotherPatientEmail, AnotherPatientContactNumber, d_ID, SheduleID, HospitalID,BookedDate,AddedDate,PatientID) "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,CURDATE(),?);";
			preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, appointment.getCheckedStatus());
			preparedStmt.setInt(2, appointment.getTokenNumber());
			preparedStmt.setString(3, appointment.getAnotherPatientStatus());
			preparedStmt.setString(4, appointment.getAnotherPatientNIC());
			preparedStmt.setString(5, appointment.getAnotherPatientName());
			preparedStmt.setString(6, appointment.getAnotherPatientEmail());
			preparedStmt.setString(7, appointment.getAnotherPatientContactNumber());
			preparedStmt.setInt(8, appointment.getD_ID());
			preparedStmt.setInt(9, appointment.getSheduleID());
			preparedStmt.setInt(10, appointment.getHospitalID());
			preparedStmt.setString(11, appointment.getBookedDate());
			preparedStmt.setInt(12, appointment.getPatientID());

			// execute the statement
			preparedStmt.execute();
			System.out.println("4");
			// get the AppointmentID of the current inserted row & assign it to
			// LastAppointmentID variable
			//GetAppointmentIdOfRecentInsert(con);
			// insert into related Payment Tables
			//GetInsertServiceFromPayment(appointment);
			con.close();
			System.out.println("5");
			String newAppointment = readAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +
					newAppointment + "\"}"; 

		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": "+
					 "\"Error while inserting the Appointment.\"}"; 
			System.err.println(e.getMessage());
			System.out.println("error " +e);
			System.out.println("came ehere");
		}
		System.out.println(output);
		return output;
	}

	public String validateData(AppointmentBean appointment) {

		// check the validity of checkedstatus
		if (appointment.getCheckedStatus() != null) {

			if (!appointment.getCheckedStatus().equals("No") && !appointment.getCheckedStatus().equals("Yes")) {
				return "Invalid Input For CheckedStatus";
			}
		} else {
			return "CheckedStatus cannot be null";
		}

		// check the validity of bookeddate
		if (appointment.getBookedDate() != null) {
			if (appointment.getBookedDate().length() == 0) {
				return "BookedDate cannot be empty";
			}
		} else {
			return "BookedDate cannot be null ";
		}

		// check the validity of AnotherPatientStatus
		if (appointment.getAnotherPatientStatus() != null) {

			if (!appointment.getAnotherPatientStatus().equals("No")
					&& !appointment.getAnotherPatientStatus().equals("Yes")) {
				return "Invalid Input For AnotherPatientStatus";
			} else {

				if (appointment.getAnotherPatientStatus().equals("Yes")) {
					// check the validity of AnotherPatientEmail

					if (validateAnotherPatientEmail(appointment) == false) {

						return "Invalid AnotherPatientEmail";
					}
					// check the validity of AnotherPatientNIC
					if (appointment.getAnotherPatientNIC() == null) {

						return "AnotherPatientNIC cannot be null";
					} else {

						if (appointment.getAnotherPatientNIC().length() == 0) {

							return "AnotherPatientNIC cannot be empty";
						}
					}
					// check the validity of AnotherPatientName
					if (appointment.getAnotherPatientName() == null) {

						return "AnotherPatientName cannot be null";
					} else {

						if (appointment.getAnotherPatientName().length() == 0) {

							return "AnotherPatientName cannot be empty";
						}
					}
					// check the validity of AnotherPatientNIC
					if (appointment.getAnotherPatientNIC() == null) {

						return "AnotherPatientNIC cannot be null";
					} else {

						if (appointment.getAnotherPatientNIC().length() == 0) {

							return "AnotherPatientNIC cannot be empty";
						}
					}
					// check the validity of AnotherPatientNIC
					if (appointment.getAnotherPatientContactNumber() == null) {

						return "AnotherPatientContactNumber cannot be null";
					} else {

						if (appointment.getAnotherPatientContactNumber().length() == 0) {

							return "AnotherPatientContactNumber cannot be empty";
						}
					}
				}
			}

		}

		// check the validity of the paymenttype

		if (appointment.getPaymentType() != null) {
			if (!appointment.getPaymentType().equals("card") && !appointment.getPaymentType().equals("online")
					&& !appointment.getPaymentType().equals("paypal")) {
				return "Invalid PaymentType";
			}
		} else {
			return "PaymentType cannot be null ";
		}

		return "good";
	}

	public boolean validateAnotherPatientEmail(AppointmentBean appointment) {

		// check for the validity of AnotherPatientEmail email
		if (appointment.getAnotherPatientEmail() != null) {
			// check the validity of email
			String emailregex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pat = Pattern.compile(emailregex);

			if (pat.matcher(appointment.getAnotherPatientEmail()).matches()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public void GetAppointmentIdOfRecentInsert(Connection con) {

		try {
			query = "SELECT AppointmentID FROM appointment ORDER BY AppointmentID DESC LIMIT 1;";
			preparedStmt = con.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				LastAppointmentID = rs.getInt("AppointmentID");
			}
		} catch (Exception e) {
			System.out.println("Error In Fetching Last Row of Appointment Table ");
		}

	}

	// this method call payment API and insert appointment details to payment table
	public String GetInsertServiceFromPayment(AppointmentBean appointment) {
		try {
			MediaType JSONType = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();
			RequestBody body = RequestBody.create("{ 'AppointmentID':'" + LastAppointmentID + "','PaymentType':'"
					+ appointment.getPaymentType() + "','Amount':'" + appointment.getAmount() + "'}", JSONType);
			Request request = new Request.Builder()
					.url("http://localhost:8080/PaymentService/api/payment/insertPaymentFromAppointment").post(body)
					.build();

			try (Response response = client.newCall(request).execute()) {
				return response.body().string();
			}
		} catch (Exception e) {
			System.out.println("Error in GetInsertSeviveFromPayment " + e);
		}
		return "Inserted Successfull to Payment";
	}

	public String updateAppointment(AppointmentBean appointment) {

		output = "";
		String validData = "";
		try {
			con = DBConnection.connect();

			if (con == null) {
				return "Error while connecting to the database for Updating.";
			}
			// check the validity of data
			validData = validateData(appointment);

			if (!validData.equals("good")) {
				return validData;
			}

			// create a prepared statement
			query = " UPDATE appointment SET " + " CheckedStatus=?, " + " TokenNumber = ?,"
					+ " AnotherPatientStatus=?, " + " AnotherPatientNIC = ?," + " AnotherPatientName= ?, "
					+ " AnotherPatientEmail = ?, " + " AnotherPatientContactNumber = ?, " + " d_ID = ?, "
					+ " SheduleID = ?, " + " HospitalID =?, " + " BookedDate = ?, " + " AddedDate = ?	"
					+ " WHERE AppointmentID = ? ;";

			preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, appointment.getCheckedStatus());
			preparedStmt.setInt(2, appointment.getTokenNumber());
			preparedStmt.setString(3, appointment.getAnotherPatientStatus());
			preparedStmt.setString(4, appointment.getAnotherPatientNIC());
			preparedStmt.setString(5, appointment.getAnotherPatientName());
			preparedStmt.setString(6, appointment.getAnotherPatientEmail());
			preparedStmt.setString(7, appointment.getAnotherPatientContactNumber());
			preparedStmt.setInt(8, appointment.getD_ID());
			preparedStmt.setInt(9, appointment.getSheduleID());
			preparedStmt.setInt(10, appointment.getHospitalID());
			preparedStmt.setString(11, appointment.getBookedDate());
			preparedStmt.setString(12, appointment.getAddedDate());
			preparedStmt.setInt(13, appointment.getAppointmentID());

			// execute the statement
			preparedStmt.executeUpdate();

			con.close();
			
			//GetUpdatetServiceFromPayment(appointment);
			String newAppointment = readAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +
					newAppointment + "\"}"; 
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": "+
					 "\"Error while updating the Appointment.\"}"; 
			System.err.println(e.getMessage());
		}

		return output;

	}

	// this method call payment API and update appointment details to payment table
	public String GetUpdatetServiceFromPayment(AppointmentBean appointment) {

		try {
			MediaType JSONType = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();
			RequestBody body = RequestBody
					.create("{ 'AppointmentID':'" + appointment.getAppointmentID() + "','PaymentType':'"
							+ appointment.getPaymentType() + "','Amount':'" + appointment.getAmount() + "'}", JSONType);
			Request request = new Request.Builder()
					.url("http://localhost:8080/PaymentService/api/payment/updatePaymentFromAppointment").put(body)
					.build();

			try (Response response = client.newCall(request).execute()) {
				return response.body().string();
			}
		} catch (Exception e) {
			System.out.println("Error in GetUpdateSeviveFromPayment " + e);
		}
		return "Update Successfull to payment";
	}

	public String deleteAppointement(AppointmentBean appointment) {
		output = "";
		try {
			// first call delete method from paymnet and delete the payment method
			//GetDeleteServiceFromPayment(appointment);

			con = DBConnection.connect();
			if (con == null) {
				return "Error while connecting to the database for Deleting.";
			}
			// create a prepared statement
			query = " DELETE FROM appointment where AppointmentID = ?";
			preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, appointment.getAppointmentID());
			// execute the statement
			preparedStmt.executeUpdate();
			con.close();
			String newAppointment = readAppointment();
			output = "{\"status\":\"success\", \"data\": \"" +
					newAppointment + "\"}"; 
		} catch (Exception e) {
			output = "{\"status\":\"error\", \"data\": "+
					 "\"Error while deleting the Appointment.\"}"; 
			System.err.println(e.getMessage());
		}
		return output;
	}

	// this method call payment API and delete appointment details to payment table
	public String GetDeleteServiceFromPayment(AppointmentBean appointment) {

		try {
			MediaType JSONType = MediaType.get("application/json; charset=utf-8");
			OkHttpClient client = new OkHttpClient();
			RequestBody body = RequestBody.create("{ 'AppointmentID':'" + appointment.getAppointmentID() + "'}",
					JSONType);
			Request request = new Request.Builder()
					.url("http://localhost:8080/PaymentService/api/payment/deletePaymentFromAppointment").delete(body)
					.build();

			try (Response response = client.newCall(request).execute()) {
				return response.body().string();
			}
		} catch (Exception e) {
			System.out.println("Error in GetDeleteSeviveFromPayment " + e);
		}
		return "Delete Successfull to Payment";
	}

}
