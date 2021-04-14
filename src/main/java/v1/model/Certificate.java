package v1.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Certificate {
	
	private UUID uuid;
	private User user;
	private LocalDate date;
	private LocalTime time;
	private String reason;
	
	public Certificate() {
		super();
		uuid = UUID.randomUUID();
	}

	public Certificate(User user, LocalDate date, LocalTime time, String reason) {
		super();
		this.uuid = UUID.randomUUID();
		this.user = user;
		this.date = date;
		this.time = time;
		this.reason = reason;
	}

	public UUID getUuid() {
		return uuid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
