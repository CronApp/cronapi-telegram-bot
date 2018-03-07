package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cronapi.telegram.bots.TelegramBotException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Method<T> {
    protected static final ObjectMapper OBJECT_MAPPER;
    private static final Logger LOGGER = Logger.getLogger(Method.class.getName());

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setVisibility(OBJECT_MAPPER.getSerializationConfig().getDefaultVisibilityChecker()
            .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
            .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
            .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        OBJECT_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T execute() throws IOException {
        URL url = new URL(String.format("https://api.telegram.org/bot%s/%s", token, this.getClass().getSimpleName()));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);

        LOGGER.fine(() -> {
            try {
                return String.format("Executing method %s with payload %s", this.getClass().getSimpleName(),
                    OBJECT_MAPPER.writeValueAsString(this));
            } catch (JsonProcessingException e) {
                LOGGER.log(Level.FINE, "Error logging method execution", e);
                return "";
            }
        });

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(OBJECT_MAPPER.writeValueAsBytes(this));
        }

        try (InputStream inputStream = connection.getInputStream()) {
            String responseString = IOUtils.toString(inputStream, "UTF-8");
            LOGGER.fine(String.format("Response from method %s: %s", this.getClass().getSimpleName(), responseString));
            Response<T> response = readResponse(responseString);
            if (response.getOk()) return response.getResult();
            throw new TelegramBotException(response.getErrorDescription());
        }
    }

    protected abstract Response<T> readResponse(String content) throws IOException;
}
