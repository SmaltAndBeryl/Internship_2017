package com.skill.India.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ValidationUtils {

	/*
	 * For checking fields containing only letters and space and hyphen
	 */
	public static boolean lettersCheck(String name) {
		return name.matches("^[\\p{L} .'-]+$");
	}		
	
	/*
	 * For checking fields containing letters and numbers (space and special 
	 * symbols not allowed )
	 */
	
	public static boolean alphanumericCheck(String name)
	{
		return name.matches("^[a-zA-Z0-9]*$");
	}
	
	/*
	 * For checking fields containing only numbers ( . is not allowed)
	 */
	
	public static boolean numbersCheck(String num)
	{
		return num.matches("[0-9]+");
	}
	

	/*
	 * For checking fields containing only numbers ( . is allowed)
	 */
	public static boolean numbersWithDecimalCheck(String decimalNum)
	{
		return decimalNum.matches("[0-9]+([,.][0-9]{1,2})?");
	}
	
	/*
	 * For checking a valid email address(spaces in email id not allowed) 
	 */
	
	public static boolean emailCheck(String email)
	{
		return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
		
	/*
	 * For checking format of date dd/mm/yyyy (send date in string format)
	 */
	
	public static boolean dateFormatCheck(String date)
	{
		return date.matches("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");	
	}
	
	/*
	 * For checking valid 10 digit mobile number (no space or hyphen allowed)
	 */
	
	public static boolean mobileNumberCheck(String mobileNumber)
	{
		return mobileNumber.matches("^\\+?[0-9]{10}$");
	}
	
	/*
	 * For checking valid 10 digit mobile number (no space or hyphen allowed)
	 */
	
	public static boolean pincodeNumberCheck(String pincode)
	{
		return pincode.matches("^\\+?[0-9]{6}$");
	}
	
	/*
	 * For converting java.util Date dd-mm-yyyy to Sql Date format yyyy-mm-dd
	 */
	
	public static String convertUtilToSqlDate(String date) throws ParseException
	{
		java.util.Date initDate = new SimpleDateFormat("dd-mm-yyyy").parse(date);
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
	    return formatter.format(initDate);
	}
	
	
	
	
}
