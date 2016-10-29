package com.pf.doctor.handler;

import static org.junit.Assert.*;

import java.util.*;
import java.util.Map.Entry;
import org.junit.Test;

public class SimilarDoctorsTest {

//Unit test for SimilarDoctors	

	@Test
	public void testAdd() {
		Doctor a = new Doctor("Sud","Jan","Belmont","M","Gastro",94002,27,1245,5);
		SimilarDoctors sd = new SimilarDoctors();
		sd.add(a);
		assertEquals(1,sd.getDocList().size());
		
	}

	@Test
	public void testGetDocList() {
		
		Doctor a = new Doctor("Sud","Jan","Belmont","M","Gastro",94002,27,1245,5);
		a.setLang(Arrays.asList("English","Spanish","German"));
		Doctor b = new Doctor("Sin","Rav","San Francisco","F","Gynaec",94002,27,12456,4);
		b.setLang(Arrays.asList("German","English"));
		Doctor c = new Doctor("Molly","Dalles","Palo Alto","F","Gynaec",94002,27,12456,3);
		c.setLang(Arrays.asList("English","Spanish","German"));
		SimilarDoctors sd = new SimilarDoctors();
		sd.add(a);
		sd.add(b);
		sd.add(c);
		assertEquals(3,sd.getDocList().size());
		assertFalse(sd.getDocList().isEmpty());
		
	}

	@Test
	public void testRankDoctor() {
		Doctor a = new Doctor("Sud","Jan","Belmont","M","Gastro",94002,27,1245,5);
		a.setLang(Arrays.asList("English","Spanish","German"));
		Doctor b = new Doctor("Sin","Rav","San Francisco","F","Gynaec",94002,27,12456,4);
		b.setLang(Arrays.asList("German","English"));
		Doctor c = new Doctor("Molly","Dalles","Palo Alto","F","Gynaec",94002,27,12456,3);
		c.setLang(Arrays.asList("English","Spanish","German"));
		Doctor d = new Doctor("Sara","Jhon","San Jose","F","Dummy",94002,27,1256,2);
		d.setLang(Arrays.asList("Spanish","German"));
		Doctor e = new Doctor("Craig","Dave","Mountain View","M","Gynaec",94002,27,1456,1);
		e.setLang(Arrays.asList("English"));
		SimilarDoctors sd = new SimilarDoctors();
		sd.add(a);
		sd.add(b);
		sd.add(c);
		sd.add(d);
		sd.add(e);
		
		Doctor f = new Doctor("Kane","Willamson","San Francisco","F","Gynaec",94002,27,1456,4);
		f.setLang(Arrays.asList("English"));
		List<Doctor> result = new ArrayList<Doctor>();
		List<Doctor> dl=sd.getDocList();
		TreeMap<Doctor,Integer> resMap = new TreeMap<Doctor,Integer>();
		resMap=sd.rankDoctor(dl,f);
		assertEquals(b.getFirstName(),resMap.firstKey().getFirstName());
		assertEquals(e.getFirstName(),resMap.lastKey().getFirstName());
			
	}



	@Test
	public void testCompareSpeciality() {
		Doctor a = new Doctor("Sud","Jan","Belmont","M","Gastro",94002,27,1245,5);
		Doctor f = new Doctor("Kane","Willamson","San Francisco","F","Gastro",94002,27,1456,4);
		SimilarDoctors sd = new SimilarDoctors();
		sd.add(a);
		List<Doctor> sp=new ArrayList<Doctor>();
		sp=sd.compareSpeciality(sd.getDocList(), f);
		assertEquals(1,sp.size());
	}

	/*@Test
	public void testCompareRating() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetRnkMap() {
		
	}

	@Test
	public void testCompareGender() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareLang() {
		fail("Not yet implemented");
	}*/

}
