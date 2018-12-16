/*---------------------------------------------------------------------------------------
//	This class is for testing purpose of getters and setters
----------------------------------------------------------------------------------------*/

package com.cg.pa.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.pa.bean.PetBean;

public class PetBeanTest 
{
	PetBean petBean=new PetBean();
	@Test
	public void testName()
	{
		petBean.setOwnerName("Sohan");
		assertEquals("Sohan", petBean.getOwnerName());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testAge()
	{
		petBean.setOwnerAge("22");
		assertEquals("22", petBean.getOwnerAge());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testId()
	{
		petBean.setOwnerId("10000");
		assertEquals("10000", petBean.getOwnerId());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testDate()
	{
		petBean.setVaccineDate("22/10/2018");
		assertEquals("22/10/2018", petBean.getVaccineDate());
		
		//fail("Not yet implemented");
	}
	
	@Test
	public void testNo()
	{
		petBean.setOwnerPhNo("7028473562");
		assertEquals("7028473562", petBean.getOwnerPhNo());
		
		//fail("Not yet implemented");
	}
	
	
}
