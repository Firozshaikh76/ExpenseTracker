package demo.com.expense_tracker.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @Column(name="categoryid", length=10)
    private String categoryId;
    
    @Column(name="id", length=10)
    private String userId;
    
    @Column(name="categoryname", length=15)
    private String categoryName;  
    
    @Column(name="Dateofcreate")
    private LocalDate dateCreate;  
    
    public String getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getCategoryName() {  // corrected method name
        return categoryName;
    }
    
    public void setCategoryName(String categoryName) {  // corrected method name
        this.categoryName = categoryName;
    }
    
    public LocalDate getDateCreate() {
        return dateCreate;
    }
    
    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }
    
    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", userId=" + userId + ", categoryName=" + categoryName
                + ", dateCreate=" + dateCreate + "]";
    }

    public Category(String categoryId, String userId, String categoryName, LocalDate dateCreate) {
        super();
        this.categoryId = categoryId;
        this.userId = userId;
        this.categoryName = categoryName;
        this.dateCreate = dateCreate;
    }

    public Category() {
        super();
    }
}
