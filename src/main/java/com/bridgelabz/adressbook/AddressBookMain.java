package com.bridgelabz.adressbook;

import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String ans = "Y";
    	while(ans.equals("Y")) {
        
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
	
	        Map<String, AddressBookDetails> addressBook = new HashMap<>();
	        addressBook.put(firstName,information);
	        for(String AddressBookDetails: addressBook.keySet()){
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
    		
    }

    }

