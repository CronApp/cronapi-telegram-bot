package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cronapi.telegram.bots.models.InputMedia;
import cronapi.telegram.bots.models.Message;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

public class SendMediaGroup extends Method<Message> {

    private static final String CHAT_ID = "chat_id";
    private static final String MEDIA = "media";
    private static final String REPLY_TO_MESSAGE_ID = "reply_to_message_id";
    private static final String DISABLE_NOTIFICATION = "disable_notification";

    private String chatId;
    private List<InputMedia> media;
    private Integer replyToMessageId;
    private Boolean disableNotification;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public List<InputMedia> getMedia() {
        return media;
    }

    public void setMedia(List<InputMedia> media) {
        this.media = media;
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

    @Override
    protected HttpEntity createBody() throws IOException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setLaxMode();
        builder.setCharset(StandardCharsets.UTF_8);
        builder.addTextBody(CHAT_ID, getChatId());
        //JsonNode
        JsonNode inputMediaList = OBJECT_MAPPER.valueToTree(media);

        //builder.addTextBody(MEDIA, OBJECT_MAPPER.writeValueAsString(media));

        for (int i = 0; i < media.size(); i++)
        {
            String inputMediaId = UUID.randomUUID().toString();
            addObjectBody(builder, inputMediaId, media.get(i).getMedia());
            ObjectNode inputMedia = (ObjectNode) inputMediaList.get(i);
            if (media.get(i).getMedia() instanceof File || media.get(i).getMedia() instanceof InputStream)
                inputMedia.put("media", "attach://" + inputMediaId);
        }

        builder.addTextBody(MEDIA, inputMediaList.toString());

        if (getDisableNotification() != null) {
            builder.addTextBody(DISABLE_NOTIFICATION, disableNotification.toString());
        }

        if (getReplyToMessageId() != null) {
            builder.addTextBody(REPLY_TO_MESSAGE_ID, replyToMessageId.toString());
        }

        return builder.build();
    }

    protected Response<Message> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<Message>>() {
        });
    }
}