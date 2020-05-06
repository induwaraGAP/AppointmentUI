<%@page import="model.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>  
<link rel="stylesheet" href="Views/bootstrap/4.4.1/css/bootstrap.min.css">
 <script src="Components/jquery-3.3.1.min.js"></script>
  <script src="Components/Appointment.js"></script>
 <script src="Views/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<div class="row">


<div class="col-12">
			<h1>Book Your Appointment</h1>
			<form id="formItem" name="formItem">
			<div class="form-row">
				
				<input id="AppointmentIDSave" name="AppointmentIDSave" type="text" hidden="true">
				
				<div class="form-group col-md-6">
			 		User ID :
			 		<input id="PatientID" name="PatientID" type="text"
			 				class="form-control form-control-sm" value ="1"  readonly>
			 	</div>
				
				<div class="form-group col-md-6">
			 		Appointment ID:
			 		<input id="AppointmentID" name="AppointmentID" type="text"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 		
		 	</div>

			
		 	 <div class="form-row">
				<div class="form-group col-md-6">
			 		Doctor Name :
			 		<input id="d_Name" name="d_Name" type="text" value = "Dr.Rohana"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 	<div class="form-group col-md-3">
			 		Doctor ID :
			 		<input id="d_ID" name="d_ID" type="text" value="67"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 	<div class="form-group col-md-3">
			 		Doctor Price :
			 		<input id="d_Price" name="d_Price" type="text" value = "500.00"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 		
		 	</div>
		 	<b>Select the hospital from the drop down by clicking Hospital Name textfield</b>
		 	<div class="form-row">
				
			 	<div class="form-group col-md-8">
			 		Hospital Name :
			 		<input id="HospitalName" name="HospitalName" type="text" autocomplete="off" placeholder = "Click here to Select"
			 				class="form-control form-control-sm" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" readonly>	 		
								
					
						<div class="collapse" id="collapseExample" >
						  <div class="card card-body">
						    <table>
						    	<tr>
						    		<th>ID</th>
						    		<th>Name</th>
						    		<th>Price</th>
						    		<th>Schedule ID</th>
						    		<th>Schedule</th>
						    		<th>Day</th>
						    		<th>Select</th>
						    	</tr>
						    	<tr>
						    		<td>1</td>
						    		<td>Hemas</td>
						    		<td>300.00</td>
						    		<td>4</td>
						    		<td>8.00am - 10.00am</td>
						    		<td>Monday</td>
						    		<td><button type="button" class="btnSelect btn btn-primary btn-sm">Select</button></td>
						    	</tr>
						    	<tr>
						    		<td>1</td>
						    		<td>Hemas</td>
						    		<td>300.00</td>
						    		<td>4</td>
						    		<td>3.00pm - 5.00pm</td>
						    		<td>Tuesday</td>
						    		<td><button type="button" class=" btnSelect btn btn-primary btn-sm">Select</button></td>
						    	</tr>
						    	<tr>
						    		<td>2</td>
						    		<td>Nawaloke</td>
						    		<td>500.00</td>
						    		<td>6</td>
						    		<td>11.00am - 2.00pm</td>
						    		<td>Wednesday</td>
						    		<td><button type="button"  class="btnSelect btn btn-primary btn-sm">Select</button></td>
						    	</tr>
						    
						    </table>
						  </div>
						</div>			 		
			 		
			 	</div>	
			 	<div class="form-group col-md-2">
			 		Hospital ID :
			 		<input id="HospitalID" name="HospitalID" type="text"
			 				class="form-control form-control-sm" readonly>	 				
			 		
			 	</div>
			 	
			 	<div class="form-group col-md-2">
			 		Hospital Price :
			 		<input id="HospitalPrice" name="HospitalPrice" type="text"
			 				class="form-control form-control-sm" readonly>	 				
			 		
			 	</div>
		 	</div>
		 	
		 	<div class="form-row">
				<div class="form-group col-md-4">
			 		Schedule ID  :
			 		<input id="ScheduleID" name="ScheduleID" type="text" autocomplete="off"
			 				class="form-control form-control-sm" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample2" readonly>	 	
									
			 	</div>
			 		
			 	<div class="form-group col-md-4">
			 		Schedule  :
			 		<input id="SheduleTime" name="SheduleTime" type="text"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 	<div class="form-group col-md-4">
			 		 Day  :
			 		<input id="Day" name="Day" type="text"
			 				class="form-control form-control-sm" readonly>
			 	</div>	
		 	</div>
		 	
		 	
		 	
		 	<div class="form-row">
				<div class="form-group col-md-4">
			 		Book Date :
			 		<input id="BookedDate" name="BookedDate" type="text"
			 				class="form-control form-control-sm" readonly>
			 	</div>
			 		
			 	<div class="form-group col-md-4">
			 		Payment Type  :
			 		<select id="PaymentType" name="PaymentType" class="form-control form-control-sm">
					  <option value="card">card</option>
					  <option value="cash">cash</option>					  
					</select>
			 	</div>	
		 	</div>
		 	<div class="form-row"  id="Updatehide" >
					
					<div class="form-group col-md-4">
				 		<b>Admin Privileges</b>Checked Status :				 		
					 	<select id="CheckedStatus" name="CheckedStatus" class="form-control form-control-sm">
						  <option value="Yes">Yes</option>
						  <option value="No">No</option>					  
						</select>
				 	</div>
				 	<div class="form-group col-md-3">
				 		Added Date :
				 		<input id="AddedDate" name="AddedDate" type="date"
				 				class="form-control form-control-sm">
				 	</div>	
			</div>
		 	<div class="form-row">
				<div class="form-group col-md-6">
			 		Amount :
			 		<input id="Amount" name="Amount" type="text"
			 				class="form-control form-control-sm" readonly>
			 				
			 		
			 	</div>			 	
			 	
		 	</div>
		 	
		 	
		 	<input type="checkbox" id="AnotherBook" name="AnotherBook" data-toggle="collapse" data-target="#collapseExample3" aria-expanded="false" aria-controls="collapseExample3" readonly>	
		 	<b>If you Book this to a another person please tick the checkbox,and fill the below form</b>
		 	<br>
		 	<div class="collapse" id="collapseExample3" >
			 	<div class="form-row">
					<div class="form-group col-md-6">
				 		NIC :
				 		<input id="AnotherPatientNIC" name="AnotherPatientNIC" type="text"
				 				class="form-control form-control-sm">
				 	</div>
				 	<div class="form-group col-md-6">
				 		Name :
				 		<input id="AnotherPatientName" name="AnotherPatientName" type="text"
				 				class="form-control form-control-sm">
				 	</div>	
			 	</div>	
			 	<div class="form-row">					
				 	<div class="form-group col-md-6">
				 		Contact Number :
				 		<input id="AnotherPatientContactNumber" name="AnotherPatientContactNumber" type="text"
				 				class="form-control form-control-sm">
				 	</div>	
				 	<div class="form-group col-md-6">
				 		Email :
				 		<input id="AnotherPatientEmail" name="AnotherPatientEmail" type="text"
				 				class="form-control form-control-sm">
				 	</div>
			 	</div>
			</div>
			
			
			
		 	
		 	
		 	
		 	
		 	
		 	<input id="btnSave" name="btnSave" type="button" value="Save"
 			class="btn btn-primary">
		 	
			</form>
			<br>
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			<br>
			<div id="divItemsGrid">
				 <%
				  Appointment app = new Appointment();
				 	out.print(app.readAppointment()); 
				 %>
			</div>
		</div>
 	</div>
</div>

</body>
</html>