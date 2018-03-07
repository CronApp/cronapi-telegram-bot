package cronapi.telegram.bots;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cronapi.CronapiMetaData;
import cronapi.telegram.bots.methods.GetMe;
import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.models.Update;
import cronapi.telegram.bots.models.User;

import java.io.IOException;
import java.util.List;

@CronapiMetaData
public class TelegramBotOperations {

    public static void main(String[] args) throws Exception {
        String token = args[0];
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);

        GetMe getMe = new GetMe();
        getMe.setToken(token);
        User user = getMe.execute();
        System.out.println(mapper.writeValueAsString(user));

        GetUpdates getUpdates = new GetUpdates();
        getUpdates.setToken(token);
        List<Update> messages = getUpdates.execute();
        System.out.println(mapper.writeValueAsString(messages));
    }

    @CronapiMetaData
    public static User getMe(GetMe param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static List<Update> getUpdates(GetUpdates param) throws IOException {
        return param.execute();
    }


//    getMe
//            sendMessage
//    forwardMessage
//            sendPhoto
//    sendAudio
//            sendDocument
//    sendVideo
//            sendVoice
//    sendVideoNote
//            sendMediaGroup
//    sendLocation
//            editMessageLiveLocation
//    stopMessageLiveLocation
//            sendVenue
//    sendContact
//            sendChatAction
//    getUserProfilePhotos
//            getFile
//    kickChatMember
//            unbanChatMember
//    restrictChatMember
//            promoteChatMember
//    exportChatInviteLink
//            setChatPhoto
//    deleteChatPhoto
//            setChatTitle
//    setChatDescription
//            pinChatMessage
//    unpinChatMessage
//            leaveChat
//    getChat
//            getChatAdministrators
//    getChatMembersCount
//            getChatMember
//    setChatStickerSet
//            deleteChatStickerSet
//    answerCallbackQuery


}
