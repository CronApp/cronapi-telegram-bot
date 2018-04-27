package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

public class KickChatMember extends JsonMethod<Boolean> {

    private String chatId;
    private Integer userId;
    private Integer untilDate;

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

    protected Response<Boolean> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Boolean>>() {
        });
    }
}