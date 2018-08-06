package book.sorting;

import java.util.ArrayList;

import book.model.Book;

public class QuickSort {

	private static ArrayList<Book> books;
	private static boolean sortByRating;
	
	// This method sorts an array and internally calls quickSort 
	public static ArrayList<Book> sort(ArrayList<Book> b, String filter){
		books = b;
		int left = 0;
		int right = books.size()-1;
		if (filter.equalsIgnoreCase("averageRating")) {
			sortByRating = true;
		} else {
			sortByRating = false;
		}
		
			
		quickSort(left, right);
		
		return books;
	}
	
	// This method is used to sort the array using quicksort algorithm.
	// It takes the left and the right end of the array as the two cursors.
	private static void quickSort(int left,int right) {
		
		// If both cursor scanned the complete array quicksort exits
		if(left >= right)
			return;
		
		// For the simplicity, we took the right most item of the array as a pivot 
		Book pivot = books.get(right);
		int partition = partition(left, right, pivot);
		
		// Recursively, calls the quicksort with the different left and right parameters of the sub-array
		quickSort(0, partition-1);
		quickSort(partition+1, right);
	}
	
	// This method is used to partition the given array and returns the integer which points to the sorted pivot index
	private static int partition(int left,int right,Book pivot){
		int leftCursor = left-1;
		int rightCursor = right;
		while(leftCursor < rightCursor){
                while(compareBook(books.get(++leftCursor), pivot) < 0);
                while(rightCursor > 0 && compareBook(books.get(--rightCursor), pivot) > 0);
			if(leftCursor >= rightCursor){
				break;
			}else{
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, right);
		return leftCursor;
	}
	
	private static double compareBook(Book b1, Book b2) {
		if (sortByRating) {
			return (double) b1.averageRating - b2.averageRating;
		} else {
			return (double) b1.popularity - b2.popularity;
		}
	}
	
	// This method is used to swap the values between the two given index
	public static void swap(int left,int right){
		Book temp = books.get(left);
		books.set(left, books.get(right));
		books.set(right, temp);
	}
}
