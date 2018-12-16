package com.cg.pa.pl;


import java.util.List;
import java.util.Scanner;
import com.cg.pa.bean.PetBean;
import com.cg.pa.exception.PetException;
import com.cg.pa.service.IPetService;
import com.cg.pa.service.PetServiceImpl;

public class PetMain 
{
	
	static IPetService petService=null;
	static PetServiceImpl petServiceImpl=null;
	static Scanner sc=new Scanner(System.in);
	
	//MAIN METHOD STARTS
	public static void main(String[] args)
	{
		PetBean petBean=null;
		String petOwnerId=null;
		int choice=0;
		while(true)
		{	
			//Displaying menu details
			System.out.println("=======================================================");
			System.out.println("\t\tPet Ownership Details\n=======================================================");
			System.out.println("Menu:-> 'What operation do you want to perform'\n");
			System.out.println("1.Add details of pet owners");
			System.out.println("2.View details");
			System.out.println("3.Remove details of existing pet owners");
			System.out.println("4.Retrieve all pet owner details");
			System.out.println("5.To view the next vaccination date");
			System.out.println("6.Exit the Menu");
			System.out.println("=======================================================");
						
			
			try
			{
				choice=sc.nextInt();
				switch(choice)
				{
				
			/*----------------------------------------------------------------
			//Option 1. For adding details of pet owner  
			----------------------------------------------------------------*/
			
				case 1:
					
					while(petBean==null)
					{	
					//Using the method called below we take inputs from user	
						petBean=populatePetBean();
						
					}
					try 
					{
						petService = new PetServiceImpl();
						petOwnerId = petService.addPetOwnerDetails(petBean);
						System.out.println("Pet Owner details has been successfully added ");
						System.out.println("Pet Owner ID Is: " + petOwnerId);
					}
					catch(PetException pe)
					{
						System.err.println("Error: "+pe.getMessage());
					}
					finally
					{
						petBean=null;
						petOwnerId=null;
						petService=null;
					}
					
					break;
					
					
				/*----------------------------------------------------------------
				//Option 2. For viewing particular record   
				----------------------------------------------------------------*/
			
				case 2:
					System.out.println("Enter the id on which u want to view the details: ");
					String sid=sc.next();
					
					try
					{
						petBean=new PetBean();
						petService=new PetServiceImpl();
						petServiceImpl=new PetServiceImpl();
						
						if(petServiceImpl.validateOwnerId(sid))
						{
							petBean=petService.viewPetOwnerDetails(sid);
							System.out.println(petBean);
						}
						else
						{
							System.out.println("Owner id is not valid ");
						}
					}
					catch(PetException exp)
					{
						System.err.println("Error not valid :"+exp.getMessage());
					}
									
					break;
					
					
				/*----------------------------------------------------------------
				////Option 3. To delete a particular record from the database.  
				----------------------------------------------------------------*/
									
				case 3:
					System.out.println("Enter the id you want to delete the details: ");
					String did=sc.next();
					
					try
					{
						petBean=new PetBean();
						petService=new PetServiceImpl();
						petServiceImpl=new PetServiceImpl();
						if(petServiceImpl.validateOwnerId(did))
						{
							petBean=petService.viewRemoveOwnerDetails(did);
							//System.out.println(petBean);
							System.out.println("Deleted record successfully");
						}
						else
						{
							System.out.println("Owner id is not valid ");
						}
					}
					catch(PetException exp)
					{
						System.err.println("Error not valid :"+exp.getMessage());
					}
					break;
			/*----------------------------------------------------------------
			//Option 4. To retrieve all the records in the database. 
			----------------------------------------------------------------*/
					
				case 4:
					try
					{
						petBean=new PetBean();
						//donorService=new DonorServiceImpl();
						petServiceImpl=new PetServiceImpl();
						List<PetBean> list=null;
						list=petServiceImpl.retriveAll();
						System.out.println(list);
						
					}
					catch(Exception e)
					{
						
					}
				
					
					break;
			
					
			/*----------------------------------------------------------------
			//Option 5. To view the details of the next Vaccination date
			----------------------------------------------------------------*/
					
				case 5:
						try
						{
							petBean=new PetBean();
							petService=new PetServiceImpl();
							petServiceImpl=new PetServiceImpl();
							petServiceImpl.knowVaccinationDate();
							//System.out.println(petBean.getNextVaccineDate());
							
						}
						catch(PetException ve)
						{
							System.err.println("Error: "+ve.getMessage());
						}
					break;
					
					
			/*----------------------------------------------------------------
			//Option 6. Exit the Menu.
			----------------------------------------------------------------*/
					
				case 6:
						System.out.print("You exited the Menu Application.");
						System.exit(0);
					break;
					default:
						System.out.println("Enter valid option among 1 to 5!!");
						break;
				}
			}
				catch(Exception e)
				{
				
				}

	}
	}
	
	
	/*----------------------------------------------------------------------------------------------
	////This method is used to get inputs from the user which is returned back to PetBean object. 
	-----------------------------------------------------------------------------------------------*/
			
	
	
	private static PetBean populatePetBean()
	{
		PetBean petBean=new PetBean();
		System.out.println("Enter Pet Owner Name: ");
		petBean.setOwnerName(sc.next());
		System.out.println("Enter Owner Contact No:");
		petBean.setOwnerPhNo(sc.next());
		System.out.println("Enter Owner Age:");
		petBean.setOwnerAge(sc.next());
		System.out.println("Enter Last date pet was vaccinated:");
		petBean.setVaccineDate(sc.next());
		petServiceImpl = new PetServiceImpl();
		
		try 
		{
			//Validation of all the user entered details takes place in the petServiceImpl class which is returned back as an object petBean. 
			petServiceImpl.validateDetails(petBean);
			
			return petBean;
		}
		catch (PetException e)
		{
			System.err.println("Invalid data:");
			System.err.println(e.getMessage() + " \n Try again..");
			System.exit(0);
			sc.next();
		}
		
		return null;
	}

}
