package sliit.proj;

public class Student {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	
	public Student(int id, String username, String password, String email, String name) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
}
