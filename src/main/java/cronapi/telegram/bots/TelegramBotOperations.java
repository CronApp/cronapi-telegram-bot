package cronapi.telegram.bots;


import cronapi.CronapiMetaData;
import cronapi.telegram.bots.methods.GetMe;
import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.Update;
import cronapi.telegram.bots.models.User;

import java.io.IOException;
import java.util.List;

@CronapiMetaData
public class TelegramBotOperations {

    @CronapiMetaData
    public static User getMe(GetMe param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static List<Update> getUpdates(GetUpdates param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static Message sendMessage(SendMessage param) throws IOException {
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
