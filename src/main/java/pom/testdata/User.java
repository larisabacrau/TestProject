package pom.testdata;

import utils.Reader;

public class User {

	private String email;

	private String password;

	public User(String filename) {
		this.email = Reader.json(filename).get("email").toString();
		this.password = Reader.json(filename).get("password").toString();
	}

	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
