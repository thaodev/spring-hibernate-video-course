package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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
			
			Student myStudent2 = new Student();
			myStudent2.setFirstName("Thao");
			myStudent2.setLastName("Nguyen");
			
			//convert java object to json data type
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(myStudent2);
			
			//print out json data to the console
			System.out.println(json);
			
			//print out json data as json file
			mapper.writeValue(new File("data/output.json"), myStudent2);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
