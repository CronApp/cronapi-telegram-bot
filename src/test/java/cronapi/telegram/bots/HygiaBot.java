package cronapi.telegram.bots;

import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.Update;

public class HygiaBot {
    public static void main(String[] args) throws InterruptedException {

        String token = "410219615:AAGgOGr_IGBOAHc20_OvlcMcdmNRc45L29s";
        GetUpdates param = new GetUpdates();
        param.setToken(token);
        String sessionId = TelegramBotOperations.startBotSession(param, updateVar -> {
            Update update = updateVar.getTypedObject(Update.class);
            SendMessage sendMessageParam = new SendMessage();
            sendMessageParam.setToken(token);
            sendMessageParam.setChatId(update.getMessage().getChat().getId().toString());
            sendMessageParam.setText("Echoing " + update.getMessage().getText());
            Message message = TelegramBotOperations.sendMessage(sendMessageParam);
        });
        Thread.sleep(10 * 60 * 1000);
        TelegramBotOperations.stopBotSession(sessionId);
    }
}
