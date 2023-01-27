package carServices;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class carServic {
	 public static void main(String[] args){
		   Scanner sc=new Scanner(System.in);
		   ServiceStation station = new ServiceStation();
		   System.out.println("Enter Car Type: ");
		   String car=sc.nextLine();
	        System.out.println("Eneter codes : BS01 ,EF01 ,CF01 ,BF01 ,GF01: \n  To Print Bill After Code Enetr : 0  ");
	        ArrayList<String> serviceCodes = new ArrayList<String>();
	        while(true) {
	        	String code=sc.nextLine();
	        	if(code.equals("0")) {
	        		break;
	        	}
	        	else if(code.equals("BS01")  || code.equals("EF01") || code.equals("CF01") || code.equals("BF01") || code.equals("GF01")) {
	        		serviceCodes.add(code);
	        	}
	        	else {
	        		System.out.println("Inalid Code Plz Check !");
	        	}
	        }
		       sc.close();
		       
		       if(car.equals("Hatchback")) {
		    	   station.printBill(CarType.Hatchback, serviceCodes);
		       }
		       else if(car.equals("Sedan")) {
		    	   station.printBill(CarType.Sedan, serviceCodes);
			   }
		       else if(car.equals("SUV")) {
		    	   station.printBill(CarType.SUV, serviceCodes);
		       }
		       else {
		    	   System.out.println("Envalid Car Type");
		     }
	      }
        }
