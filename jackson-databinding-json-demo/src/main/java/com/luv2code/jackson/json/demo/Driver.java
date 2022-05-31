package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read JSON file and map/convert to Java POJO
			Student myStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			// print first name and last name 
			
			System.out.println("Client First Name is " + myStudent.getFirstName());
			System.out.println("Client Last Name is " + myStudent.getLastName());
			
			System.out.println("Student street addess is " + myStudent.getAddress().getStreet());

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
