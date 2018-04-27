package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import java.io.IOException;

public class ForwardMessage extends JsonMethod<Message> {

    private String chatId;
    private String fromChatId;
    private Integer messageId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getFromChatId() {
        return fromChatId;
    }

    public void setFromChatId(String fromChatId) {
        this.fromChatId = fromChatId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    @Override
    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}