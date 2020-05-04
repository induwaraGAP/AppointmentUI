	package beans;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AppointmentBean {
	private int AppointmentID ;
	private int d_ID;
	private int SheduleID;
	private int HospitalID;
	private String CheckedStatus;  
	private int TokenNumber ;	
	private String AnotherPatientStatus ;
	private String AnotherPatientNIC  ;
	private String AnotherPatientName  ;
	private String AnotherPatientEmail ; 
	private String AnotherPatientContactNumber ;
	private String BookedDate;
	private String AddedDate;
	private String PaymentType;
	private JsonObject AppointmentObject;
	private double Amount;
	private int PatientID;
	
	public String getBookedDate() {
		return BookedDate;
	}
	public void setBookedDate(String bookedDate) {
		BookedDate = bookedDate;
	}
	public String getAddedDate() {
		return AddedDate;
	}
	public void setAddedDate(String addedDate) {
		AddedDate = addedDate;
	}
	public int getAppointmentID() {
		return AppointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		AppointmentID = appointmentID;
	}
	public int getD_ID() {
		return d_ID;
	}		
	
	public void setD_ID(int d_ID) {
		this.d_ID = d_ID;
	}
	public int getSheduleID() {
		return SheduleID;
	}
	public void setSheduleID(int sheduleID) {
		SheduleID = sheduleID;
	}
	public int getHospitalID() {
		return HospitalID;
	}
	public void setHospitalID(int hospitalID) {
		HospitalID = hospitalID;
	}
	public String getCheckedStatus() {
		return CheckedStatus;
	}
	public void setCheckedStatus(String checkedStatus) {
		CheckedStatus = checkedStatus;
	}
	public int getTokenNumber() {
		return TokenNumber;
	}
	public void setTokenNumber(int tokenNumber) {
		TokenNumber = tokenNumber;
	}
	
	public String getAnotherPatientStatus() {
		return AnotherPatientStatus;
	}
	public void setAnotherPatientStatus(String anotherPatientStatus) {
		AnotherPatientStatus = anotherPatientStatus;
	}
	public String getAnotherPatientNIC() {
		return AnotherPatientNIC;
	}
	public void setAnotherPatientNIC(String anotherPatientNIC) {
		AnotherPatientNIC = anotherPatientNIC;
	}
	public String getAnotherPatientName() {
		return AnotherPatientName;
	}
	public void setAnotherPatientName(String anotherPatientName) {
		AnotherPatientName = anotherPatientName;
	}
	public String getAnotherPatientEmail() {
		return AnotherPatientEmail;
	}
	public void setAnotherPatientEmail(String anotherPatientEmail) {
		AnotherPatientEmail = anotherPatientEmail;
	}
	public String getAnotherPatientContactNumber() {
		return AnotherPatientContactNumber;
	}
	public void setAnotherPatientContactNumber(String anotherPatientContactNumber) {
		AnotherPatientContactNumber = anotherPatientContactNumber;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	} 
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	
	public int getPatientID() {
		return PatientID;
	}
	public void setPatientID(int patientID) {
		PatientID = patientID;
	}
	public void convertStringToJSONInsert(String appointmentData) {
		//convert string to JSON object and assign to variables in the class
		AppointmentObject  = new JsonParser().parse(appointmentData).getAsJsonObject(); 		
		setCheckedStatus(AppointmentObject.get("CheckedStatus").getAsString());
		setTokenNumber(AppointmentObject.get("TokenNumber").getAsInt());
		setAnotherPatientStatus(AppointmentObject.get("AnotherPatientStatus").getAsString());
		setAnotherPatientNIC(AppointmentObject.get("AnotherPatientNIC").getAsString());
		setAnotherPatientName(AppointmentObject.get("AnotherPatientName").getAsString());
		setAnotherPatientEmail(AppointmentObject.get("AnotherPatientEmail").getAsString());
		setAnotherPatientContactNumber(AppointmentObject.get("AnotherPatientContactNumber").getAsString());
		setD_ID(AppointmentObject.get("d_ID").getAsInt());
		setSheduleID(AppointmentObject.get("SheduleID").getAsInt());
		setHospitalID(AppointmentObject.get("HospitalID").getAsInt());
		setBookedDate(AppointmentObject.get("BookedDate").getAsString());
		setPaymentType(AppointmentObject.get("PaymentType").getAsString());
		setPatientID(AppointmentObject.get("PatientID").getAsInt());
		setAmount(AppointmentObject.get("Amount").getAsDouble());
	}
	public void convertStringToJSONUpdate(String appointmentData) {
		//convert string to JSON object and assign to variables in the class
		AppointmentObject  = new JsonParser().parse(appointmentData).getAsJsonObject(); 		
		setAppointmentID(AppointmentObject.get("AppointmentID").getAsInt());
		setCheckedStatus(AppointmentObject.get("CheckedStatus").getAsString());
		setTokenNumber(AppointmentObject.get("TokenNumber").getAsInt());
		setAnotherPatientStatus(AppointmentObject.get("AnotherPatientStatus").getAsString());
		setAnotherPatientNIC(AppointmentObject.get("AnotherPatientNIC").getAsString());
		setAnotherPatientName(AppointmentObject.get("AnotherPatientName").getAsString());
		setAnotherPatientEmail(AppointmentObject.get("AnotherPatientEmail").getAsString());
		setAnotherPatientContactNumber(AppointmentObject.get("AnotherPatientContactNumber").getAsString());
		setD_ID(AppointmentObject.get("d_ID").getAsInt());
		setSheduleID(AppointmentObject.get("SheduleID").getAsInt());
		setHospitalID(AppointmentObject.get("HospitalID").getAsInt());
		setBookedDate(AppointmentObject.get("BookedDate").getAsString());
		setAddedDate(AppointmentObject.get("AddedDate").getAsString());
		setAmount(AppointmentObject.get("Amount").getAsDouble());
		setPatientID(AppointmentObject.get("PatientID").getAsInt());
		setPaymentType(AppointmentObject.get("PaymentType").getAsString());
		
	}
	public void convertStringToJSONSelect(String appointmentData) {
		//convert string to JSON object and assign to variables in the class
		AppointmentObject  = new JsonParser().parse(appointmentData).getAsJsonObject(); 		
		setAppointmentID(AppointmentObject.get("AppointmentID").getAsInt());
		setPatientID(AppointmentObject.get("PatientID").getAsInt());
	}
	public void convertStringToJSONDelete(String appointmentData) {
		//convert string to JSON object and assign to variables in the class
		AppointmentObject  = new JsonParser().parse(appointmentData).getAsJsonObject(); 		
		setAppointmentID(AppointmentObject.get("AppointmentID").getAsInt());
	}
	




}