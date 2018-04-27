package cronapi.telegram.bots;


import cronapi.CronapiMetaData;
import cronapi.ParamMetaData;
import cronapi.telegram.bots.methods.*;
import cronapi.telegram.bots.models.*;
import cronapi.util.Callback;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TelegramBotOperations {

    private static final Map<String, TelegramBotSession> botSessions = new HashMap<>();

    public static User getMe(GetMe param) throws IOException {
        return param.execute();
    }

    @CronapiMetaData
    public static List<Update> getUpdates(GetUpdates param) throws IOException {
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
    public static String startBotSession(GetUpdates param,
        @ParamMetaData(type = CronapiMetaData.ObjectType.STATEMENTSENDER) Callback handler) {
        TelegramBotSession botSession = new TelegramBotSession(param, handler);
        String botId = UUID.randomUUID().toString();
        synchronized (botSessions) {
            botSessions.put(botId, botSession);
            botSession.start();
        }
        return botId;
    }

    public static Message forwardMessage(ForwardMessage param) throws IOException {
        return param.execute();
    }

    public static UserProfilePhotos getUserProfilePhotos(GetUserProfilePhotos param)
        throws IOException {
        return param.execute();
    }

    public static File getFile(GetFile param) throws IOException {
        return param.execute();
    }

    public static Boolean kickChatMember(KickChatMember param) throws IOException {
        return param.execute();
    }

    public static Boolean unbanChatMember(UnbanChatMember param) throws IOException {
        return param.execute();
    }

    public static Boolean restrictChatMember(RestrictChatMember param) throws IOException {
        return param.execute();
    }

    public static Boolean promoteChatMember(PromoteChatMember param) throws IOException {
        return param.execute();
    }

    public static String exportChatInviteLink(ExportChatInviteLink param) throws IOException {
        return param.execute();
    }

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
