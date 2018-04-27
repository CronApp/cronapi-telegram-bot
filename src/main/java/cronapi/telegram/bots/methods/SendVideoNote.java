package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.ReplyMarkup;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import jdk.nashorn.internal.ir.ObjectNode;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class SendVideoNote extends Method<Message> {

    private static final String CHATID_FIELD = "chat_id";
    private static final String VIDEONOTE_FIELD = "video_note";
    private static final String DURATION_FIELD = "duration";
    private static final String LENGTH_FIELD = "length";
    private static final String DISABLENOTIFICATION_FIELD = "disable_notification";
    private static final String REPLYTOMESSAGEID_FIELD = "reply_to_message_id";
    private static final String REPLYMARKUP_FIELD = "reply_markup";
    private String chatId;
    private Object videoNote;
    private Integer duration;
    private Integer length;
    private Boolean disableNotification;
    private Integer replyToMessageId;
    private ReplyMarkup replyMarkup;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    private Object getVideoNote() {
        return videoNote;
    }

    public void setVideoNote(Object videoNote) {
        this.videoNote = videoNote;
    }

    private Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    private Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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
        builder.addTextBody(CHATID_FIELD, getChatId());

        addObjectBody(builder, VIDEONOTE_FIELD, videoNote);

        if (replyMarkup != null) {
            builder.addTextBody(REPLYMARKUP_FIELD,
                OBJECT_MAPPER.writeValueAsString(replyMarkup));
        }
        if (replyToMessageId != null) {
            builder.addTextBody(REPLYTOMESSAGEID_FIELD, replyToMessageId.toString());
        }
        if (duration != null) {
            builder.addTextBody(DURATION_FIELD, duration.toString());
        }
        if (length != null) {
            builder.addTextBody(LENGTH_FIELD, length.toString());
        }
        if (disableNotification != null) {
            builder.addTextBody(DISABLENOTIFICATION_FIELD, disableNotification.toString());
        }
        return builder.build();
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}