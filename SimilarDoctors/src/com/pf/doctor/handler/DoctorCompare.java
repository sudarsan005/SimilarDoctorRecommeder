package com.pf.doctor.handler;

import java.util.Comparator;
import java.util.HashMap;

//comparator to sort map
public class DoctorCompare implements Comparator<Doctor>{

	HashMap<Doctor, Integer> map = new HashMap<Doctor, Integer>();
	 
	public DoctorCompare(HashMap<Doctor, Integer> map){
		this.map.putAll(map);
	}
	@Override
	public int compare(Doctor d1, Doctor d2) {
		if(map.get(d1) >= map.get(d2)){
			return -1;
		}else{
			return 1;
		}	
	}
}


