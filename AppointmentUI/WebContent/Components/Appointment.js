$(document).ready(function()
{
	
	if ($("#alertSuccess").text().trim() == "")
	 {
		$("#alertSuccess").hide();
	 }
	 $("#alertError").hide();
	 $("#Updatehide").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	 $("#alertSuccess").text("");
	 $("#alertSuccess").hide();
	 $("#alertError").text("");
	 $("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	 {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	 }
	var type = ($("#AppointmentIDSave").val() == "") ? "POST" : "PUT";

	 $.ajax(
		{
		 url : "API_Appointment",
		 type : type,
		 data : $("#formItem").serialize(),
		 dataType : "text",
		 complete : function(response, status)
		 {
			 onItemSaveComplete(response.responseText, status);
		 }
	 });
	// If valid------------------------
	// $("#formItem").submit(); 
	
}); 


function onItemSaveComplete(response, status)
{
	if (status == "success") {
		
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error") {
			
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
		
	} else {
		
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
		
	}
	
	$("#hidItemIDSave").val("");
	$("#Updatehide").hide();
	$('#collapseExample3').collapse('hide');
	$("#formItem")[0].reset();
}

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	//redo previous
	 $('#AnotherBook').prop('checked', false);	
	 $("#AnotherPatientNIC").val("");
	 $("#AnotherPatientName").val("");
	 $("#AnotherPatientEmail").val("");
	 $("#AnotherPatientContactNumber").val("");
	
	
	 $("#AppointmentIDSave").val($(this).closest("tr").find('#hidAppointmentIDUpdate').val());
	 $("#PatientID").val($(this).closest("tr").find('td:eq(1)').text());
	 $("#AppointmentID").val($(this).closest("tr").find('td:eq(0)').text());
	 $("#d_ID").val($(this).closest("tr").find('td:eq(9)').text());
	 $("#HospitalID").val($(this).closest("tr").find('td:eq(11)').text());
	 $("#ScheduleID").val($(this).closest("tr").find('td:eq(10)').text());
	 $("#BookedDate").val($(this).closest("tr").find('td:eq(13)').text());
	 $("#HospitalPrice").val(300.00);
	 $("#SheduleTime").val("11.00am - 2.00pm");
	 $("#Day").val("Monday");
	 $("#HospitalName").val("Hemas");
	 $("#Updatehide").show();
	 $("#CheckedStatus").val($(this).closest("tr").find('td:eq(2)').text());
	 $("#AddedDate").val($(this).closest("tr").find('td:eq(12)').text());

	 //check for another patient type then check the tickbox
	 if($(this).closest("tr").find('td:eq(4)').text()=="Yes"){
		 $('#AnotherBook').prop('checked', true);
		 $('#collapseExample3').collapse();
		 $("#AnotherPatientNIC").val($(this).closest("tr").find('td:eq(5)').text());
		 $("#AnotherPatientName").val($(this).closest("tr").find('td:eq(6)').text());
		 $("#AnotherPatientEmail").val($(this).closest("tr").find('td:eq(7)').text());
		 $("#AnotherPatientContactNumber").val($(this).closest("tr").find('td:eq(8)').text());
	 } 
 
	 //Cal Total Amount
	var total = +($("#HospitalPrice").val()) + +($("#d_Price").val())  ;
	$("#Amount").val(total.toFixed(2));
 

});

//DELETE==========================================
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax(
	 {
		 url : "API_Appointment",
		 type : "DELETE",
		 data : "AppointmentID=" + $(this).data("appointmentid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
			 onItemDeleteComplete(response.responseText, status);
		 }
	 });
});

function onItemDeleteComplete(response, status)
{
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divItemsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

//CLIENTMODEL=========================================================================
function validateItemForm()
{
	//Hospital Name
	if ($("#HospitalName").val().trim() == "")
	{
		return "Select Hospital Name.";
	}
	
	//AnotherBook
	if($("#AnotherBook").prop('checked') == true){
	    
		
		//AnotherPatientNIC
		if ($("#AnotherPatientNIC").val().trim() == ""){
			
			return "Insert Other Patient NIC.";		
		}
		
		//check the vaidity of NIC		
		if ($("#AnotherPatientNIC").val().trim().length < 10){
			
			return "NIC should have 10 Characters.";		
		}
		
		//AnotherPatientnName
		if ($("#AnotherPatientName").val().trim() == ""){
			
			return "Insert Other Other Patient Name.";		
		}
		
		
		//AnotherPatientEmail
		if ($("#AnotherPatientEmail").val().trim() == ""){
			
			return "Insert Other Other Patient Email.";		
		}
		
		//AnotherPatientEmail Pattern Validate
		if ($("#AnotherPatientEmail").val().trim() != ""){
			
			var email = $("#AnotherPatientEmail").val();
			var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			
			if(!regex.test(email))
			{
				return "InValide Email.";
			}
				
			
		}
		
		//cal the validity of phone number	
		if ($("#AnotherPatientContactNumber").val().trim() != ""){
			
			if($("#AnotherPatientContactNumber").val().length < 10){
				return "Wrong Phone Number";
			}	
		}
		
		//AnotherPatientContactNumber
		if ($("#AnotherPatientContactNumber").val().trim() == ""){
			
			return "Insert Other Patient Contact Number.";		
		}
		
				

		
	}
	

	return true;
}

//Dropdown select==========================================
$(document).on("click", ".btnSelect", function(event)
{	
	$("#HospitalID").val($(this).closest("tr").find('td:eq(0)').text());
	$("#HospitalName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#HospitalPrice").val($(this).closest("tr").find('td:eq(2)').text());
	$("#ScheduleID").val($(this).closest("tr").find('td:eq(3)').text());
	$("#SheduleTime").val($(this).closest("tr").find('td:eq(4)').text());
	$("#Day").val($(this).closest("tr").find('td:eq(5)').text());
	
	//have to autogenerate the bookingdate
	var day = $(this).closest("tr").find('td:eq(5)').text();
	var dayIndex = calDayNumber(day);
	var nextdate = CalNextDay(dayIndex);
	//insert the next booking date to Book Date Field
	$("#BookedDate").val(nextdate);
	
	
	//Cal Total Amount
	var total = +($("#HospitalPrice").val()) + +($("#d_Price").val())  ;
	$("#Amount").val(total.toFixed(2));

});

//calculate the autogenerated the booking date
function CalNextDay(dow_number)
{
	var CurrentDay = new Date();
    CurrentDay.setDate(CurrentDay.getDate() + (dow_number - 1 - CurrentDay.getDay() + 7) % 7 + 1);
    var CorrectFormat = 'Y-m-d'
    	  .replace('Y', CurrentDay.getFullYear())
    	  .replace('m', CurrentDay.getMonth()+1)
    	  .replace('d', CurrentDay.getDate());
    
    
    return CorrectFormat;
}	

//calculate the day number
function calDayNumber(day)
{
	if(day == "Sunday"){
		return 0;
	}
	else if(day == "Monday"){
		return 1;
	}
	else if(day == "Tuesday"){
		return 2;
	}
	else if(day == "Wednesday"){
		return 3;
	}
	else if(day == "Thursday"){
		return 4;
	}
	else if(day == "Friday"){
		return 5;
	}
	else {
		return 6;
	}
}
