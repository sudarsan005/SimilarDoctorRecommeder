package com.pf.doctor.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Doctor data 
		Doctor a = new Doctor("Sud","Jan","Belmont","M","Gastro",94002,40,1245,5);
		a.setLang(Arrays.asList("English","Spanish","German"));
		Doctor b = new Doctor("Sin","Rav","San Francisco","F","Gynaec",94068,47,12456,4);
		b.setLang(Arrays.asList("German","English"));
		Doctor c = new Doctor("Molly","Dalles","Palo Alto","F","Gynaec",94032,42,12456,3);
		c.setLang(Arrays.asList("English","Spanish","German"));
		Doctor d = new Doctor("Sara","Jhon","San Jose","F","Dummy",94056,357,1256,2);
		d.setLang(Arrays.asList("Spanish","German"));
		Doctor e = new Doctor("Craig","Dave","Mountain View","M","Gynaec",94021,57,1456,1);
		e.setLang(Arrays.asList("English"));
		//add doctors to memory
		SimilarDoctors sd = new SimilarDoctors();
		sd.add(a);
		sd.add(b);
		sd.add(c);
		sd.add(d);
		sd.add(e);
		
		//doctor to be compared against
		Doctor f = new Doctor("Kane","Willamson","San Francisco","F","Gynaec",94002,57,1456,4);
		f.setLang(Arrays.asList("English"));
		
		List<Doctor> result = new ArrayList<Doctor>();
		List<Doctor> dl=sd.getDocList();
		
		TreeMap<Doctor,Integer> resMap = new TreeMap<Doctor,Integer>();
		resMap=sd.rankDoctor(dl,f);
		
		System.out.println("Recommended Similar Doctors Ordered by Priority");
		
		for(Entry<Doctor, Integer> dmap : resMap.entrySet())
			System.out.println("Name: "+ dmap.getKey().getFirstName() + " " +  dmap.getKey().getLastName() +
					" Speciality: " + dmap.getKey().getSpeciality() + " Rating: " + dmap.getKey().getRating() +  
					" City: " + dmap.getKey().getCity() +
 					" Languages Known: " + dmap.getKey().getLang() + " RankingScore: " + dmap.getValue());
		
	}

}
