package cronapi.telegram.bots;


import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;
import cronapi.telegram.bots.methods.GetMe;
import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.Update;
import cronapi.telegram.bots.models.User;
import cronapi.util.Callback;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CronapiMetaData
public class TelegramBotOperations {

    private static final Map<String, TelegramBotSession> botSessions = new HashMap<>();

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

    @CronapiMetaData
    public static void stopBotSession(String sessionId) {
        TelegramBotSession botSession;
        synchronized (botSessions) {
            botSession = botSessions.remove(sessionId);
        }
        botSession.interrupt();
    }

    @CronapiMetaData
    public static String startBotSession(GetUpdates param, @ParamMetaData(type = CronapiMetaData.ObjectType.STATEMENTSENDER) Callback handler) {
        TelegramBotSession botSession = new TelegramBotSession(param, handler);
        String botId = UUID.randomUUID().toString();
        synchronized (botSessions) {
            botSessions.put(botId, botSession);
            botSession.start();
        }
        return botId;
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
