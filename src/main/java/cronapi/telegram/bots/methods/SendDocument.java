package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.ReplyMarkup;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class SendDocument extends Method<Message> {

    private static final String CHAT_ID = "chat_id";
    private static final String DOCUMENT = "document";
    private static final String CAPTION = "caption";
    private static final String DISABLE_NOTIFICATION = "disable_notification";
    private static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    private static final String REPLY_MARKUP = "reply_markup";
    private static final String PARSE_MODE = "parse_mode";

    private String chatId;
    private Object document;
    private String caption;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyMarkup replyMarkup;
    private String parseMode;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Object getDocument() {
        return document;
    }

    public void setDocument(Object document) {
        this.document = document;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
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

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    @Override
    protected HttpEntity createBody() throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setLaxMode();
        builder.setCharset(StandardCharsets.UTF_8);

        builder.addTextBody(CHAT_ID, chatId, ContentType.TEXT_PLAIN);
        addObjectBody(builder, DOCUMENT, document);

        if (replyMarkup != null) {
            builder.addTextBody(REPLY_MARKUP, OBJECT_MAPPER.writeValueAsString(replyMarkup));
        }
        if (getReplyToMessageId() != null) {
            builder.addTextBody(REPLY_TO_MESSAGE_ID, replyToMessageId.toString());
        }
        if (getCaption() != null) {
            builder.addTextBody(CAPTION, caption);
            if (getParseMode() != null) {
                builder.addTextBody(PARSE_MODE, parseMode);
            }
        }
        if (getDisableNotification() != null) {
            builder.addTextBody(DISABLE_NOTIFICATION, disableNotification.toString());
        }
        return builder.build();
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}