package demo.com.expense_tracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Notifications {
	@Id
    @Column(name="notifyid", length=10)
    private String notifyId;
    
    @Column(name="id", length=10)
    private String userId;
    
    @Column(name="message", length=60)
    private String message;  
    
    @Column(name="Dateofpush")
    private LocalDate datePush;

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDatePush() {
		return datePush;
	}

	public void setDatePush(LocalDate datePush) {
		this.datePush = datePush;
	}

	@Override
	public String toString() {
		return "Notifications [notifyId=" + notifyId + ", userId=" + userId + ", message=" + message + ", datePush="
				+ datePush + "]";
	}

	public Notifications(String notifyId, String userId, String message, LocalDate datePush) {
		super();
		this.notifyId = notifyId;
		this.userId = userId;
		this.message = message;
		this.datePush = datePush;
	}

	public Notifications() {
		super();
		// TODO Auto-generated constructor stub
	}
}
