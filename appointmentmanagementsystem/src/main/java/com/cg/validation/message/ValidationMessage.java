package com.cg.validation.message;

public class ValidationMessage {

    public static final String NULLAPPOINTMENTID="please enter a valid Appointment Id, null value not accepted";
	
    public static final String NULLUSERID="please enter a valid User Id, null value not accepted";
	
    public static final String NULLCREATORID="please enter a valid Appointment creator Id, null value not accepted";
	
    public static final String BLANKDATE="please enter a valid Date, null or blank value not accepted";
	
    public static final String BLANKTIME="please enter a valid Time, null or blank value not accepted";
	
    public static final String NULLDESCRIPTION="please enter a valid Description, null value not accepted";
	
    public static final String BLANKUSERNAME="please enter a valid User Name, null or blank value not accepted";
	
    public 	static final String BLANKNAME="please enter a valid  Name, null or blank value not accepted";
	
    public 	static final String BLANKEMAILID="please enter a valid Email Id ,null or blank value not accepted";
	
    public 	static final String BLANKMOBILENO="please enter a valid Mobile Number ,null or blank value not accepted";
	
    public 	static final String BLANKPASSWORD="please enter a valid Password ,null or blank value not accepted";
	
    public 	static final String VALIDMOBILENO="Mobile Number Should be of 10 digit starting with 7,8,9";
	
    public 	static final String VALIDEMAILID="Email Id is invalid please Enter a valid Email Id";
	
    public 	static final String VALIDPASSWORD="Password Should be of length 8 to 20 with atleast 1 uppercase,1 lowercase,"
										+ "1 number and 1 special character";
	
    private ValidationMessage() {
    	throw  new UnsupportedOperationException("Static values present");
    }
}
