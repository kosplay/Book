package book.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


import book.model.*;

/**
 *	Add review for a book. 
 */
public class ReviewController {
	public ArrayList<Review> list;
	
	public ReviewController() {
		list = new ArrayList<Review>();
		try {
	        // Create an object of file reader
	        // class with CSV file as a parameter.
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat("/src/reviews.csv");
	        Scanner scanner = new Scanner(new File(filePath));
	        scanner.useDelimiter(",");
	        boolean skipFirstLine = true;
	        while(scanner.hasNext()){
        		if(skipFirstLine) {
        			skipFirstLine = false;
        			scanner.hasNext();
        		}
	            Review review = new Review(
	            		Integer.parseInt(scanner.next()),
	            		Integer.parseInt(scanner.next()), 
	            		Integer.parseInt(scanner.next()), 
	            		Integer.parseInt(scanner.next()),
	            		scanner.next()
    				);
	            this.list.add(review);
	        }
	        scanner.close();
	        System.out.println("Loaded reviews");
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public Review create(int user_id, int book_id, int rating, String content) {
		int id = this.list.size() + 1;
		Review newReview = new Review(id, user_id, book_id, rating, content);
		return newReview;
	}
	
	public ArrayList<Review> gerReviews(int start) {
		ArrayList<Review> result = new ArrayList<Review>();
		int end = start+10;
		for (int i=start; i<end; i++) {
			result.add(list.get(i));
		}
		return result;
	}
}
