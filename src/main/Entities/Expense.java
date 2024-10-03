package demo.com.expense_tracker.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expense {
	@Id
    @Column(name="expenseid", length=10)
    private String expenseId;
    
    @Column(name="id", length=10)
    private String userId;
    
    @Column(name="categoryid", length=10)
    private String categoryId;
    
    @Column(name="amount", length=10)
    private int Amount;  
    
    @Column(name="Dateofexpense")
    private LocalDate dateExpense;

	public String getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
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

	public LocalDate getDateExpense() {
		return dateExpense;
	}

	public void setDateExpense(LocalDate dateExpense) {
		this.dateExpense = dateExpense;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", userId=" + userId + ", categoryId=" + categoryId + ", Amount="
				+ Amount + ", dateExpense=" + dateExpense + "]";
	}

	public Expense(String expenseId, String userId, String categoryId, int amount, LocalDate dateExpense) {
		super();
		this.expenseId = expenseId;
		this.userId = userId;
		this.categoryId = categoryId;
		Amount = amount;
		this.dateExpense = dateExpense;
	}

	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}

	public void setNewDate(LocalDate now) {
		// TODO Auto-generated method stub
		
	}
}
