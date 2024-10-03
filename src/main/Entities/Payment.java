package demo.com.expense_tracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
    @Column(name="paymentid", length=10)
    private String paymentId;
    
    @Column(name="id", length=10)
    private String userId;
    
    @Column(name="details", length=10)
    private String Details;  
    
    @Column(name="Dateofpayment")
    private LocalDate datePayment;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public LocalDate getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(LocalDate datePayment) {
		this.datePayment = datePayment;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", Details=" + Details + ", datePayment="
				+ datePayment + "]";
	}

	public Payment(String paymentId, String userId, String details, LocalDate datePayment) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		Details = details;
		this.datePayment = datePayment;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
