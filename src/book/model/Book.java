package book.model;

import java.util.ArrayList;

public class Book {
	public int id;
	public String ISBN;
	public int year;
	public int month;
	public String color;
	public String title;
	public int popularity;
	public double averageRating;
	
	public Book(int id, String isbn, int year, int month, String color, String title) {
		this.id = id;
		this.ISBN = isbn;
		this.year = year;
		this.month = month;
		this.color = color;
		this.title = title;
		this.popularity = 0;
		this.averageRating = 0;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", ISBN=" + ISBN + ", year=" + year + ", month=" + month + ", color=" + color
				+ ", title=" + title + ", popularity=" + popularity + ", averageRating=" + averageRating + "]";
	}
	
	public void addReview(Review review) {
		double prevTotal = this.popularity * this.averageRating; 
		this.popularity += 1;
		this.averageRating = (prevTotal + review.rating) / this.popularity;
		double l = (double) (this.averageRating * 100);
		l = Math.round(l);
		this.averageRating = (double) (l / 100);
	}
	
	public void addReviews(ArrayList<Review> reviews) {
		for (Review review : reviews) {
			this.addReview(review);
		}
	}
}
