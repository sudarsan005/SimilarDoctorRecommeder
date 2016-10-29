package com.pf.doctor.handler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
import java.util.TreeMap;

public class SimilarDoctors {
	private List<Doctor> dl = new ArrayList<Doctor>();
	private HashMap<Doctor,Integer> rnkMap = new HashMap<Doctor,Integer>();

	public HashMap<Doctor, Integer> getRnkMap() {
		return rnkMap;
	}

	public void add(Doctor d)
	{
		dl.add(d);
		
	}
	
	public List<Doctor> getDocList()
	{
		return dl;
	}
	
	public TreeMap<Doctor,Integer> rankDoctor (List<Doctor> dl, Doctor d){
		List<Doctor> res=new ArrayList<Doctor>();
		res=compareSpeciality(dl,d);
		compareRating(res,d);
		compareGender(res,d);
		compareCity(res,d);
		compareLang(res,d);
		TreeMap<Doctor,Integer> resMap = new TreeMap<Doctor,Integer>();
		resMap=sortMapByValue(rnkMap);
		return resMap;
	}
	
	//sort map
	public TreeMap<Doctor, Integer> sortMapByValue(HashMap<Doctor, Integer> map){
		Comparator<Doctor> comparator = new DoctorCompare(map);
		TreeMap<Doctor, Integer> result = new TreeMap<Doctor, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	//compare doc with similar speciality and add only those who match
	public List<Doctor> compareSpeciality (List<Doctor> dl, Doctor d)
	{
		List<Doctor> sp=new ArrayList<Doctor>();
		for(Doctor ld: dl)
		{
			if(ld.getSpeciality().equals(d.getSpeciality()))
				sp.add(ld);
			
		}
		return sp;
	}
	
	//provide rank score for doc's rating
	public void compareRating (List<Doctor> dl, Doctor d)
	{
		for(Doctor ld: dl)
		{
			rnkMap.put(ld,ld.getRating());
		}
		
	}
	
	//provide rank score for doc's gender
	public void compareGender (List<Doctor> dl, Doctor d)
	{
		for(Doctor ld: dl)
		{
			if(d.getGender().equals(ld.getGender()))
					rnkMap.put(ld,rnkMap.get(ld)+5);
		}
		
	}
	//provide rank score for doc's city
	public void compareCity (List<Doctor> dl, Doctor d)
	{
		for(Doctor ld: dl)
		{
			if(d.getCity().equals(ld.getCity()))
				rnkMap.put(ld,rnkMap.get(ld)+5);
		}
		
	}

	//provide rank score for doc's Languages spoken
	public void compareLang (List<Doctor> dl, Doctor d)
	{
		for(Doctor ld: dl)
		{
			HashSet<String> exisDocLang=new HashSet(ld.getLang());
			HashSet<String> docLang=new HashSet(d.getLang());
			docLang.retainAll(exisDocLang);
			if((docLang!=null && docLang.size()>0)) 
				rnkMap.put(ld,rnkMap.get(ld)+docLang.size());
		}
		
	}
}

