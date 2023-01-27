package carServices;

import java.util.HashMap;

public class Service {
	    private String code;
	    private String name;
	    private HashMap<CarType,Integer> prices;

	    public Service(String code, String name, Integer priceHatchback, Integer priceSedan, Integer priceSUV) {
	        this.code = code;
	        this.name = name;
	        this.prices = new HashMap<>();
	        this.prices.put(CarType.Hatchback,priceHatchback);
	        this.prices.put(CarType.Sedan,priceSedan);
	        this.prices.put(CarType.SUV,priceSUV);
	    }

	    public String getCode() {
	        return code;
	    }

	    public String getName() {
	        return name;
	    }

	  

		public int getPrice(CarType carType) {
	        return this.prices.get(carType);
	    }
}
