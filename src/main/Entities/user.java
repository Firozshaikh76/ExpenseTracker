package demo.com.expense_tracker.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class user {
		
		@Id
		@Column(name="id", length=10)
		private String userId;
		@Column(name="username", length=15)
		private String username;
		@Column(name="password", length=20)
		private String password;
		@Column(name="Dateofjoined")
		private LocalDate DateJoined;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
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
		public LocalDate getDateJoined() {
			return DateJoined;
		}
		public void setDateJoined(LocalDate dateJoined) {
			DateJoined = dateJoined;
		}
		@Override
		public String toString() {
			return "user [userId=" + userId + ", username=" + username + ", password=" + password + ", DateJoined="
					+ DateJoined + "]";
		}
		public user(String userId, String username, String password, LocalDate dateJoined) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
			DateJoined = dateJoined;
		}
		public user() {
			super();
			// TODO Auto-generated constructor stub
		}
}
