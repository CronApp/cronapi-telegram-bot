package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

public class UnbanChatMember extends JsonMethod<Boolean> {

    private String chatId;
    private String userId;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    protected Response<Boolean> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Boolean>>() {
        });
    }
}
