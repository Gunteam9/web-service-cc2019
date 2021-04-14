package v1.model;

import java.time.LocalDate;

public class User {

	private String username;
	private String password;
	private LocalDate date;
	private String place;
	private boolean isPolice;
	
	public User() {
		super();
		this.isPolice = false;
	}
	
	public User(String username, String password, LocalDate date, String place) {
		super();
		this.username = username;
		this.password = password;
		this.date = date;
		this.place = place;
		this.isPolice = false;
	} 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean isPolice() {
		return isPolice;
	}

	public void setPolice(boolean isPolice) {
		this.isPolice = isPolice;
	}
	
}
