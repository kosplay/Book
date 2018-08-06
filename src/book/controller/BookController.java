package book.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

import book.model.*;
import book.sorting.*;

/**
 *	Add, remove book. 
 */
public class BookController {
	public ArrayList<Book> list;
	public ArrayList<Book> quickSorted;
	public ArrayList<Book> bubbleSorted;
	
	public BookController() {
		list = new ArrayList<Book>();
		try {
	        // Create an object of file reader
	        // class with CSV file as a parameter.
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat("/src/books.csv");
	        Scanner scanner = new Scanner(new File(filePath));
	        scanner.useDelimiter(",");
	        boolean skipFirstLine = true;
	        while(scanner.hasNext()){
	        		if(skipFirstLine) {
	        			skipFirstLine = false;
	        			scanner.hasNext();
	        		}
	            Book b = new Book(
	            		Integer.parseInt(scanner.next()),
	            		scanner.next(), 
	            		Integer.parseInt(scanner.next()), 
	            		Integer.parseInt(scanner.next()),
	            		scanner.next(), scanner.next()
            		);
	            this.list.add(b);
	        }
	        scanner.close();
	        System.out.println("Loaded books");
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void quickSort(String sortBy) {
		this.quickSorted = (ArrayList<Book>) list.clone();
		this.quickSorted = QuickSort.sort(quickSorted, sortBy);
	}
	
	public void bubbleSort(String sortBy) {
		this.bubbleSorted = (ArrayList<Book>) list.clone();
		this.bubbleSorted = (ArrayList<Book>) BubbleSort.sort(bubbleSorted, sortBy);
	}
	
	public Book create(String isbn, int year, int month, String color, String title) {
		int id = list.size() + 1;
		Book newBook = new Book(id, isbn, year, month, color, title);
		return newBook;
	}
	
	public Book get(int id) {
		for (Book book : this.list) {
			if (book.id == id) {
				return book;
			}
		}
		return null;
	}
	
	public ArrayList<Book> getBooks(ArrayList<Book> books, int start) {
		ArrayList<Book> result = new ArrayList<Book>();
		int end = start+10;
		for (int i=start; i<end; i++) {
			result.add(books.get(i));
		}
		return result;
	}
	
	public ArrayList<Book> searchByTitleContain(String str) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (Book book : this.list) {
			if (book.title.matches("(.*)"+ str +"(.*)")) {
				result.add(book);
			}
		}
		return result;
	}
	
	public void addReview(Review review) {
		for (Book book : this.list) {
			if (book.id == review.book_id) {
				book.addReview(review);
			}
		}
	}
	
	public void removeBook(int book_id) {
		for (Book b: this.list) {
			if (b.id == book_id) {
				list.remove(b);
				System.out.println("The following book is removed!");
				System.out.println(b);
			}
		}
	}
	
	public void addReviews(ArrayList<Review> reviews) {
		for (Review review: reviews) {
			this.addReview(review);
		}
	}
}
