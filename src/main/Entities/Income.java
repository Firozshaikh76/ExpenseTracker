package demo.com.expense_tracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Income {
	 @Id
	    @Column(name="incomeid", length=10)
	    private String incomeId;
	    
	    @Column(name="id", length=10)
	    private String userId;
	    
	    @Column(name="amount", length=10)
	    private int Amount;  
	    
	    @Column(name="Dateofsalary")
	    private LocalDate dateSalary;

		public String getIncomeId() {
			return incomeId;
		}

		public void setIncomeId(String incomeId) {
			this.incomeId = incomeId;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public int getAmount() {
			return Amount;
		}

		public void setAmount(int amount) {
			Amount = amount;
		}

		public LocalDate getDateSalary() {
			return dateSalary;
		}

		public void setDateSalary(LocalDate dateSalary) {
			this.dateSalary = dateSalary;
		}

		@Override
		public String toString() {
			return "Income [incomeId=" + incomeId + ", userId=" + userId + ", Amount=" + Amount + ", dateSalary="
					+ dateSalary + "]";
		}

		public Income(String incomeId, String userId, int amount, LocalDate dateSalary) {
			super();
			this.incomeId = incomeId;
			this.userId = userId;
			Amount = amount;
			this.dateSalary = dateSalary;
		}

		public Income() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
