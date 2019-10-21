package com.luv2code.jackson.json.demo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			
			//create opbject mapper
			try{  
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:sqlserver://DESKTOP-NDFP9CJ\\\\SA:1433;databaseName=employee_directory","sa","asdqwe123.");  
				//here sonoo is database name, root is username and password  
            System.out.println(con);
				con.close();  
				}catch(Exception e){ System.out.println(e);}  
				
			ObjectMapper mapper=new ObjectMapper();
			//read json file and Map/Convert to POJO:
			Student theStudent=mapper.readValue(new File("data/sample-lite.json"), Student.class);
			System.out.println(theStudent);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
