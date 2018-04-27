package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.ReplyMarkup;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class SendAudio extends Method<Message> {

    private static final String DURATION = "duration";
    private static final String CHAT_ID = "chat_id";
    private static final String AUDIO = "audio";
    private static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    private static final String DISABLE_NOTIFICATION = "disable_notification";
    private static final String REPLY_MARKUP = "reply_markup";
    private static final String PERFORMER = "performer";
    private static final String TITLE = "title";
    private static final String CAPTION = "caption";
    private static final String PARSE_MODE = "parse_mode";

    private Integer duration;
    private String chatId;
    private Object audio;
    private Integer replyToMessageId;
    private Boolean disableNotification;
    private ReplyMarkup replyMarkup;
    private String performer;
    private String title;
    private String caption;
    private String parseMode;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Object getAudio() {
        return audio;
    }

    public void setAudio(Object audio) {
        this.audio = audio;
    }

    public Integer getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(Integer replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    public ReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(ReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    protected HttpEntity createBody() throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setLaxMode();
        builder.setCharset(StandardCharsets.UTF_8);
        builder.addTextBody(CHAT_ID, chatId, ContentType.TEXT_PLAIN);

        addObjectBody(builder, AUDIO, audio);

        if (replyMarkup != null) {
            builder.addTextBody(REPLY_MARKUP, OBJECT_MAPPER.writeValueAsString(replyMarkup),
                ContentType.TEXT_PLAIN);
        }

        if (replyToMessageId != null) {
            builder.addTextBody(REPLY_TO_MESSAGE_ID, replyToMessageId.toString(),
                ContentType.TEXT_PLAIN);
        }

        if (performer != null) {
            builder.addTextBody(PERFORMER, performer, ContentType.TEXT_PLAIN);
        }

        if (title != null) {
            builder.addTextBody(TITLE, title, ContentType.TEXT_PLAIN);
        }

        if (duration != null) {
            builder.addTextBody(DURATION, duration.toString(), ContentType.TEXT_PLAIN);
        }

        if (disableNotification != null) {
            builder.addTextBody(DISABLE_NOTIFICATION, disableNotification.toString(),
                ContentType.TEXT_PLAIN);
        }

        if (caption != null) {
            builder.addTextBody(CAPTION, caption, ContentType.TEXT_PLAIN);
            if (parseMode != null) {
                builder.addTextBody(PARSE_MODE, parseMode, ContentType.TEXT_PLAIN);
            }
        }

        return builder.build();
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}