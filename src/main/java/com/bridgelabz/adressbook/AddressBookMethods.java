package com.bridgelabz.adressbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBookMethods {
	Map<String, HashMap<String, AddressBookDetails>> primeAddressBook = new HashMap<>();
	static AddressBookDetails information = null;
	Map<String, AddressBookDetails> addressBook = new HashMap<>();
	Map<String, AddressBookDetails> preAddressBook = new HashMap<>();
	Map<String, AddressBookDetails> addressBookByCity = new HashMap<>();
	Map<String, AddressBookDetails> addressBookByState = new HashMap<>();
	Scanner sc = new Scanner(System.in);
	
     //--------------without using stream---------------//	
	
	public void editContact(Map<String, AddressBookDetails> addressBook,
			AddressBookDetails information)
	{
		System.out.println("Enter the name of person u want to edit details : ");
		String editInfoOfName = sc.next();
		addressBook.replace(editInfoOfName, information, infoObjectCreater());
	    }
	
	private void deleteContact(Map<String, AddressBookDetails> addressBook,
			AddressBookDetails information) 
	{
		System.out.println("Enter the name of person u want to delete details : ");
		String editInfoOfName = sc.next();
		addressBook.remove(editInfoOfName);
	    }
	
	//-----------------with stream----------------------//
	
	private void searchContactByCity(AddressBookDetails information) {
		System.out.println("Enter city name = ");
		String cityNameForSearch = sc.next();
		
		Map<String,AddressBookDetails> searchAddressBookByCity =addressBookByCity.entrySet().stream()
				.filter(e->e.getKey().equals(cityNameForSearch))
				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		System.out.println(searchAddressBookByCity.toString());
		System.out.println("Number of person " + searchAddressBookByCity.size() + " in city " + cityNameForSearch);
	}
	
	private void searchContactByState(AddressBookDetails information) {
		System.out.println("Enter city name = ");
		String stateNameForSearch = sc.next();
		
		Map<String,AddressBookDetails> searchAddressBookByState =addressBookByCity.entrySet().stream()
				.filter(e->e.getKey().equals(stateNameForSearch))
				.collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
		System.out.println(searchAddressBookByState);
		System.out.println("Number of person " + searchAddressBookByState.size() + " in State " + stateNameForSearch);
	}
	
			//---------------------sorting-----------------------//
	public void sortByCity() {

		Map<String,AddressBookDetails> sortedByCity =addressBookByCity.entrySet().stream()
				      						.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue
				      							,(oldValue,newValue)->oldValue,LinkedHashMap::new));
		System.out.println("Sorted Address Book "+sortedByCity);
		
	}
    public void sortByState() {

		Map<String,AddressBookDetails> sortedByState =addressBookByState.entrySet().stream()
				      						.sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue
				      							,(oldValue,newValue)->oldValue,LinkedHashMap::new));
		System.out.println("Sorted Address Book "+sortedByState);
		
	}

	public AddressBookDetails infoObjectCreater() {
		Scanner sc = new Scanner(System.in);
		 /*----------------Strings----------------------*/
        System.out.println("Enter first name = ");
        String firstName = sc.next();
        System.out.println("Enter Last name = ");
        String lastName = sc.next();
        System.out.println("Enter Address = ");
        String address = sc.next();
        System.out.println("Enter City = ");
        String subCity = sc.next();
        System.out.println("Enter  State = ");
        String state = sc.next();
        System.out.println("Enter  Email= ");
        String email = sc.next();
        
        //-------------int & long---------------//
        System.out.println("Enter zip code = ");
        int Zip = sc.nextInt();
        System.out.println("Enter phone Number = ");
        long PhoneNumber = sc.nextLong();
        
        AddressBookDetails information = new AddressBookDetails(firstName,lastName,address,subCity,state,email,Zip,PhoneNumber);
        return information;
        }
	
	
	public void addContact()
	{
		Scanner sc = new Scanner(System.in);
		boolean cond = true;
		while(cond) {
			System.out.println("Enter the name of ur address book");
			String nameOfAddressBook = sc.next();
			
	    	primeAddressBook.put(nameOfAddressBook,(HashMap<String, AddressBookDetails>) addressBook);
	    	String ans = "Y";
	    	AddressBookDetails information = null;
	    	System.out.println("--------Contacts in " + nameOfAddressBook + "---------");
	    	
	    	//-----boolean is not used coz here ans is controlling looping condition u can see that at end of while loop---//
	    	
resume:	    while(ans.equals("Y"))
	    	{
	        
	            //----------------Strings----------------------//
	
	        System.out.println("Enter first name = ");
	            String firstName = sc.next();
	            if(addressBook.containsKey(firstName)) {
	            	System.err.println("Person already exist..enter valid input!");
	            	continue resume;
	            }
	            System.out.println("Enter Last name = ");
	            String lastName = sc.next();
	            System.out.println("Enter Address = ");
	            String address = sc.next();
	            System.out.println("Enter City = ");
	            String subCity = sc.next();
	            System.out.println("Enter  State = ");
	            String state = sc.next();
	            System.out.println("Enter  Email= ");
	            String email = sc.next();
	            
	            //-------------int & long---------------//
	            System.out.println("Enter zip code = ");
	            int Zip = sc.nextInt();
	            System.out.println("Enter phone Number = ");
	            long PhoneNumber = sc.nextLong();                        
	            
	            
	            
	            information = new AddressBookDetails(firstName,lastName,address,subCity,state,email,Zip,PhoneNumber);
	            preAddressBook.put(subCity, information);

	            addressBookByCity.put(subCity, information);
	            addressBookByState.put(state, information);
		        addressBook.put(firstName,information);
		    
		        
		        
		        for(String AddressBookDetails: addressBook.keySet())
		        {
		            System.out.println("firstName = " + information.getFirstName() +
		                    "\nlast Name = "+ information.getLastName() +
		                    "\naddress = "+ information.getAddress() +
		                    "\ncity = "+ information.getCity() +
		                    "\nstate = "+ information.getState() +
		                    "\nemail = "+ information.getEmail() +
		                    "\nZip = "+ information.getZipCode() +
		                    "\nPhoneNumber = "+ information.getPhoneNumber());
	        	};
	        	
	        	System.out.println("Do you want to add new contact (Y-yes/N-no): ");
	        	ans = sc.next();
	        }
	    		System.out.println("Edit Contact (press 1)"
	    				+ "\nDelete Contact (press 2)"
	    				+ "\nCreat New Adressbook (press 3)"
	    				+ "Search person by City (press 4)"
	    				+ "Search person by State (press 5)");
	    		int action = sc.nextInt();
	    		switch(action) {
	    			case 1: editContact(addressBook,information);
	    			break;
	    			
	    			case 2: deleteContact(addressBook,information);
	    			break;
	    			
	    			case 3: addContact();
	    			break;
	    			
	    			case 4: searchContactByCity(information);
	    			break;
	    			
	    			case 5: searchContactByState(information);
	    			break;
	    			
	    			default: System.err.println("invalid input");
	    				
    		}
		}
	}
}
