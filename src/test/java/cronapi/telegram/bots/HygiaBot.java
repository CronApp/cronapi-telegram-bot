package cronapi.telegram.bots;

import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.methods.SendLocation;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.methods.SendVideoNote;
import cronapi.telegram.bots.models.InlineKeyboardButton;
import cronapi.telegram.bots.models.InlineKeyboardMarkup;
import cronapi.telegram.bots.models.Update;
import java.io.File;
import java.util.ArrayList;

public class HygiaBot {

    public static void main(String[] args) throws InterruptedException {
        String token = "410219615:AAGgOGr_IGBOAHc20_OvlcMcdmNRc45L29s";
        GetUpdates param = new GetUpdates();
        param.setToken(token);
        String sessionId = TelegramBotOperations.startBotSession(param, updateVar -> {
            Update update = updateVar.getTypedObject(Update.class);

            SendMessage sendMessage = new SendMessage();
            InlineKeyboardMarkup replyMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton button1 = new InlineKeyboardButton();
            button1.setText("Botão 1");
            button1.setCallbackData("button1");

            InlineKeyboardButton button2 = new InlineKeyboardButton();
            button2.setText("Botão 2");
            button2.setCallbackData("button2");

            replyMarkup.setInlineKeyboard(new ArrayList<>());
            replyMarkup.getInlineKeyboard().add(new ArrayList<>());
            replyMarkup.getInlineKeyboard().get(0).add(button1);
            replyMarkup.getInlineKeyboard().get(0).add(button2);


//            sendMessage.setText("Texto da Mensagem");
//            sendMessage.setReplyMarkup(replyMarkup);
//            sendMessage.setToken(token);
//            sendMessage.setChatId(String.valueOf(update.getMessage().getChat().getId()));
//            SendOperations.sendMessage(sendMessage);

            SendLocation sendLocation = new SendLocation();
            sendLocation.setToken(token);
            sendLocation.setChatId(String.valueOf(update.getMessage().getChat().getId()));
            sendLocation.setLatitude(-23.4643123f);
            sendLocation.setLongitude(-46.8731798f);
            sendLocation.setReplyMarkup(replyMarkup);
            SendOperations.sendLocation(sendLocation);

            System.out.println(update.getMessage().getText());
        });
        Thread.sleep(10 * 60 * 1000);
        TelegramBotOperations.stopBotSession(sessionId);
    }
}
