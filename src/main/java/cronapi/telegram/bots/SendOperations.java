package cronapi.telegram.bots;

import cronapi.CronapiMetaData;
import cronapi.telegram.bots.methods.SendAudio;
import cronapi.telegram.bots.methods.SendChatAction;
import cronapi.telegram.bots.methods.SendContact;
import cronapi.telegram.bots.methods.SendDocument;
import cronapi.telegram.bots.methods.SendLocation;
import cronapi.telegram.bots.methods.SendMediaGroup;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.methods.SendPhoto;
import cronapi.telegram.bots.methods.SendVenue;
import cronapi.telegram.bots.methods.SendVideo;
import cronapi.telegram.bots.methods.SendVideoNote;
import cronapi.telegram.bots.methods.SendVoice;
import cronapi.telegram.bots.models.Message;
import java.io.IOException;

@CronapiMetaData
public class SendOperations {

    private SendOperations() {

    }

    @CronapiMetaData
    public static Message sendMessage(SendMessage param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendPhoto(SendPhoto param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendAudio(SendAudio param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendDocument(SendDocument param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendVideo(SendVideo param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendVoice(SendVoice param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendVideoNote(SendVideoNote param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendMediaGroup(SendMediaGroup param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendLocation(SendLocation param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendVenue(SendVenue param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendContact(SendContact param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendChatAction(SendChatAction param) throws IOException {
        return param.execute();
    }
}