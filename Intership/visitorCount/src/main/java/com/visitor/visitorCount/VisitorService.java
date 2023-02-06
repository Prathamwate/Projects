package com.visitor.visitorCount;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {
	
	
	HashMap<String  ,Integer> hm=new HashMap<>();
	
	
//	public int Count() {
//		return count++;
//	}
	public HashMap<String,Integer> fetchName(String visit) {
	    hm.put(visit,hm.getOrDefault(visit, 0)+1);
	   return  hm;
	}
}
