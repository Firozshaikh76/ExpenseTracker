package demo.com.expense_tracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Budget {
	@Id
    @Column(name="budgetid", length=10)
    private String budgetId;
    
    @Column(name="id", length=10)
    private String userId;
    
    @Column(name="categoryid", length=10)
    private String categoryId;
    
    @Column(name="amount", length=10)
    private int Amount;  
    
    @Column(name="Dateofstart")
    private LocalDate dateStart;
    
    @Column(name="Dateofend")
    private LocalDate dateEnd;

	public String getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(String budgetId) {
		this.budgetId = budgetId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "Budget [budgetId=" + budgetId + ", userId=" + userId + ", categoryId=" + categoryId + ", Amount="
				+ Amount + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}

	public Budget(String budgetId, String userId, String categoryId, int amount, LocalDate dateStart,
			LocalDate dateEnd) {
		super();
		this.budgetId = budgetId;
		this.userId = userId;
		this.categoryId = categoryId;
		Amount = amount;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	
	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setEndDate(LocalDate endDate) {
		// TODO Auto-generated method stub
		
	}

	public void setStartDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}
}
