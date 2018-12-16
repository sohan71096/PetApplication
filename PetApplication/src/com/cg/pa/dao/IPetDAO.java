package com.cg.pa.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.pa.bean.PetBean;
import com.cg.pa.exception.PetException;

/*--------------------------------------------------------------------------------------
//This interface consists of methods that are to be used in the Pet Adoption Application
---------------------------------------------------------------------------------------*/

public interface IPetDAO
{
	public String addPetOwnerDetails(PetBean donor) throws PetException, SQLException, ClassNotFoundException, IOException;
	public List<PetBean> retriveAll()throws PetException, SQLException, ClassNotFoundException, IOException;
	public PetBean viewPetOwnerDetails(String petOwnerId) throws PetException, ClassNotFoundException, IOException, SQLException;
	public PetBean viewRemoveOwnerDetails(String petOwnerId) throws PetException, ClassNotFoundException, IOException, SQLException;
	public void knowVaccinationDate() throws PetException, ClassNotFoundException, IOException, SQLException; 
}
