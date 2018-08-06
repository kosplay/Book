package book.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import book.model.*;

/**
 *	Immutable user. 
 */
public class UserController {
	public ArrayList<User> list;
	
	public UserController() {
		list = new ArrayList<User>();
		try {
	        // Create an object of file reader
	        // class with CSV file as a parameter.
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat("/src/users.csv");
	        Scanner scanner = new Scanner(new File(filePath));
	        scanner.useDelimiter(",");
	        boolean skipFirstLine = true;
	        while(scanner.hasNext()){
        		if(skipFirstLine) {
        			skipFirstLine = false;
        			scanner.hasNext();
        		}
	            User user = new User(Integer.parseInt(scanner.next()), scanner.next(), scanner.next(), scanner.next());
	            this.list.add(user);
	        }
	        scanner.close();
	        System.out.println("Loaded users");
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
//	public Book create(Book book) {
//		
//	}
}
