package in.fssa.knfunding.model;

public class RequestEntity {
	
	
    private int id;
    private String title;
    private String description;
    private int category_id;
    private int amount;

    public RequestEntity() {
    }

    public RequestEntity(int id, String title, String description, int category_id, int amount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category_id = category_id;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                ", amount=" + amount +
                '}';
    }
}
