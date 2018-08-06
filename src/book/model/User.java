package book.model;

public class User {
	public int id;
	public String first_name;
	public String last_name;
	public String email;
	
	public User(int id, String first_name, String last_name, String email) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + "]";
	}
}
