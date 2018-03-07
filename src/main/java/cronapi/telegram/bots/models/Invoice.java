package cronapi.telegram.bots.models;

public class Invoice {
    private String title;
    private String description;
    private String startParameter;
    private String currency;
    private Integer totalAmount;
    private PhotoSize photo;

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

    public String getStartParameter() {
        return startParameter;
    }

    public void setStartParameter(String startParameter) {
        this.startParameter = startParameter;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PhotoSize getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoSize photo) {
        this.photo = photo;
    }
}