package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.ReplyMarkup;
import java.io.IOException;

public class SendVenue extends JsonMethod<Message> {

    private String chatId;
    private Float latitude;
    private Float longitude;
    private String title;
    private Boolean disableNotification;
    private String address;
    private String foursquareId;
    private Integer replyToMessageId;
    private ReplyMarkup replyMarkup;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(String foursquareId) {
        this.foursquareId = foursquareId;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}