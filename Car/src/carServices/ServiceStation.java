package carServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceStation {
	  private Map<String, Service> services;

	    public ServiceStation() {
	        services = new HashMap<>();
	        services.put("BS01", new Service("BS01", "Basic Service", 2000, 4000, 5000));
	        services.put("EF01", new Service("EF01", "Engine Fixing", 5000, 8000, 10000));
	        services.put("CF01", new Service("CF01", "Clutch Fixing", 2000, 4000, 6000));
	        services.put("BF01", new Service("BF01", "Break Fixing", 1000, 1500, 2500));
	        services.put("GF01", new Service("GF01", "Gear Fixing", 3000, 6000, 8000));
	    }

	    public Service getService(String code) {
	        return services.get(code);
	    }

	    public void printBill(CarType carType, List<String> serviceCodes) {
	        double bill = 0;
	        for (String code : serviceCodes) {
	            Service service = getService(code);
	            bill += service.getPrice(carType);
	            System.out.println(service.getName()+" : "+service.getPrice(carType));
	        }
	        if(bill>=10000){
	            System.out.println("In Additional You Get a FREE Car Cleaning ");            
	             System.out.println("Total Service Bill  : " + bill );
	        }
	        else{
	              System.out.println("Total Service Bill : " + bill );
	        }
	       
	    }
}
