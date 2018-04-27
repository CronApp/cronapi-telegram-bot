package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

public class RestrictChatMember extends JsonMethod<Boolean> {

    private String chatId;
    private Integer userId;
    private Integer untilDate;
    private Boolean canSendMessages;
    private Boolean canSendMediaMessages;
    private Boolean canSendOtherMessages;
    private Boolean canAddWebPagePreviews;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(Integer untilDate) {
        this.untilDate = untilDate;
    }

    public Boolean getCanSendMessages() {
        return canSendMessages;
    }

    public void setCanSendMessages(Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
    }

    public Boolean getCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    public void setCanSendMediaMessages(Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
    }

    public Boolean getCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    public void setCanSendOtherMessages(Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
    }

    public Boolean getCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    public void setCanAddWebPagePreviews(Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
    }

    @Override
    protected Response<Boolean> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Boolean>>() {
        });
    }
}