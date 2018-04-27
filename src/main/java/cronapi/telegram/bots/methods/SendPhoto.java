package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.ReplyMarkup;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class SendPhoto extends Method<Message> {

    private static final String CHAT_ID = "chat_id";
    private static final String PHOTO = "photo";
    private static final String CAPTION = "caption";
    private static final String DISABLE_NOTIFICATION = "disable_notification";
    private static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    private static final String REPLY_MARKUP = "reply_markup";
    private static final String PARSE_MODE = "parse_mode";

    private String chatId;
    private String caption;
    private String parseMode;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyMarkup replyMarkup;
    private Object photo;

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
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

    @Override
    protected HttpEntity createBody() throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setLaxMode();
        builder.setCharset(StandardCharsets.UTF_8);

        builder.addTextBody(CHAT_ID, chatId, ContentType.TEXT_PLAIN);

        addObjectBody(builder, PHOTO, photo);

        if (caption != null) {
            builder.addTextBody(CAPTION, caption, ContentType.TEXT_PLAIN);
        }

        if (parseMode != null) {
            builder.addTextBody(PARSE_MODE, parseMode, ContentType.TEXT_PLAIN);
        }

        if (disableNotification != null) {
            builder.addTextBody(DISABLE_NOTIFICATION, disableNotification.toString(),
                ContentType.TEXT_PLAIN);
        }

        if (replyToMessageId != null) {
            builder.addTextBody(REPLY_TO_MESSAGE_ID, replyToMessageId.toString(),
                ContentType.TEXT_PLAIN);
        }

        if (replyMarkup != null) {
            builder.addTextBody(REPLY_MARKUP, OBJECT_MAPPER.writeValueAsString(replyMarkup),
                ContentType.TEXT_PLAIN);
        }

        return builder.build();
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}