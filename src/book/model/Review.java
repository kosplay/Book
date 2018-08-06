package book.model;

public class Review {
	public int id;
	public int user_id;
	public int book_id;
	public int rating;
	public String content;
	
	public Review(int id, int user_id, int book_id, int rating, String content) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.rating = rating;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", rating=" + rating
				+ ", content=" + content + "]";
	}
}
