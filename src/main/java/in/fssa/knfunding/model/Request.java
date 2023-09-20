package in.fssa.knfunding.model;


public class Request  {
    private int id;
    private String description;
    private int categoryId;
    private int amount;
    private String title;
    private boolean isActive;
    private int user_id;
    
    private String img_url;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

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
	

	
	
    
    
    
    
    
   
    
}
