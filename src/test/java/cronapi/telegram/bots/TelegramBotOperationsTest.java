package cronapi.telegram.bots;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import cronapi.telegram.bots.methods.GetMe;
import cronapi.telegram.bots.methods.GetUpdates;
import cronapi.telegram.bots.methods.SendMessage;
import cronapi.telegram.bots.models.Message;
import cronapi.telegram.bots.models.Update;
import cronapi.telegram.bots.models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TelegramBotOperationsTest {

    private static String token;
    private static ObjectMapper OBJECT_MAPPER;
    private List<Update> updates;

    @BeforeClass
    public static void BeforeClass()
    {
        token = System.getProperty("token");

        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setVisibility(OBJECT_MAPPER.getSerializationConfig().getDefaultVisibilityChecker()
            .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
            .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);
        OBJECT_MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    public void getMeTest() throws IOException {
        GetMe param = new GetMe();
        param.setToken(token);
        User user = TelegramBotOperations.getMe(param);
        System.out.println(OBJECT_MAPPER.writeValueAsString(user));
    }

    @Test
    public void getUpdatesTest() throws IOException {
        GetUpdates param = new GetUpdates();
        param.setToken(token);
        updates = TelegramBotOperations.getUpdates(param);
        System.out.println(OBJECT_MAPPER.writeValueAsString(updates));
    }

    @Test(dependsOnMethods = {"getUpdatesTest"})
    public void sendMessageTest() throws IOException {
        for (Update update: updates) {
            SendMessage param = new SendMessage();
            param.setToken(token);
            param.setChatId(update.getMessage().getChat().getId().toString());
            param.setText("Echoing " + update.getMessage().getText());
            Message message = TelegramBotOperations.sendMessage(param);
            System.out.println(OBJECT_MAPPER.writeValueAsString(message));
        }
    }


}
