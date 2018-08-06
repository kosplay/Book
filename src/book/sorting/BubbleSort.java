package book.sorting;

import java.util.ArrayList;

import book.model.Book;

public class BubbleSort {
	private static ArrayList<Book> books;
	private static boolean sortByRating;
	
	public static ArrayList<Book> sort(ArrayList<Book> b, String filter){
		books = b;
		if (filter.equalsIgnoreCase("averageRating")) {
			sortByRating = true;
		} else {
			sortByRating = false;
		}
		
		for(int i=0; i < books.size(); i++) {
			for(int j=0; j < books.size(); j++) {
				if (compareBook(books.get(i), books.get(j)) > 0) {
					Book temp = books.get(j);
					books.set(j,  books.get(i));
					books.set(i, temp);
				}
			}
		}
		return books;
	}
	
	public static double compareBook(Book b1, Book b2) {
		if (sortByRating) {
			return (double) b1.averageRating - b2.averageRating;
		} else {
			return (double) b1.popularity - b2.popularity;
		}
	}
}

