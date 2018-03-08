package cronapi.telegram.bots.models;

public class KeyboardButton {
    private String text;
    private Boolean requestContact;
    private Boolean requestLocation;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRequestContact() {
        return requestContact;
    }

    public void setRequestContact(Boolean requestContact) {
        this.requestContact = requestContact;
    }

    public Boolean getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(Boolean requestLocation) {
        this.requestLocation = requestLocation;
    }
}