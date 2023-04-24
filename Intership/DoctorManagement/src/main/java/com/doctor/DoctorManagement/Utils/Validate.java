package com.doctor.DoctorManagement.Utils;

import java.util.regex.Pattern;

public class Validate {

	public static boolean isNameValid(String name) {
		if(name.length()>=3) {
			return true;
		}
		return false;
	}

	public static boolean isCityValid(String cityname) {
		if(cityname.equals("Delhi")) {
			return true;
		}
		if(cityname.equals("Noida")) {
			return true;
		}
		if(cityname.equals("Faridabad")) {
			return true;
		}
		return false;
	}
	
	public static boolean isCityValidforPatient(String cityname) {
		if(cityname.length()>=20) {
		    return false;
		}
		return true;
	}
	
	

	public static boolean isValidPhone(String phone) {
		 if(phone.length()!=10) { return false; }
		 
		 else {
			 for(char c:phone.toCharArray()) {
				 if(!(c>=48 && c<=57))
					 return false;
			 }
			 return true;
		 }
	}

	public static boolean isValidEmail(String email) {
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                "[a-zA-Z0-9_+&*-]+)*@" +
	                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                "A-Z]{2,7}$";

	        Pattern pat = Pattern.compile(emailRegex);
	        return pat.matcher(email).matches();
		
	}
	
	
	
	
	

}
