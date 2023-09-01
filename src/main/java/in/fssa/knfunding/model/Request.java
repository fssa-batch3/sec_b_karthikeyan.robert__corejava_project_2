package in.fssa.knfunding.model;

public class Request  {
    private int id;
    private String description;
    private int categoryId;
    private int amount;
    private String title;
    private boolean isActive;
    
    
    public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(double amount2) {
		this.amount = (int) amount2;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getUserId() {
		return getUserId();
	}
	public int setUserId(int userId) {
		return userId;
	}

	
	
	
    
    
    
    
    
   
    
}
