package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import cronapi.telegram.bots.BotException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public abstract class Method<T> {
    static final ObjectMapper OBJECT_MAPPER;
    private static final Logger LOGGER = Logger.getLogger(Method.class.getName());

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER
            .setVisibility(OBJECT_MAPPER.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        OBJECT_MAPPER
            .setPropertyNamingStrategy(PropertyNamingStrategy.SnakeCaseStrategy.SNAKE_CASE);
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T execute() throws IOException {
        String uri = String.format("https://api.telegram.org/bot%s/%s", getToken(),
            this.getClass().getSimpleName());
        HttpPost post = new HttpPost(uri);
        post.setEntity(createBody());

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            try (CloseableHttpResponse httpResponse = client.execute(post)) {
                if (httpResponse.getStatusLine().getStatusCode() != 200)
                {
                    throw new BotException(httpResponse.getStatusLine().getReasonPhrase());
                }

                HttpEntity responseEntity = httpResponse.getEntity();
                String responseString = EntityUtils.toString(responseEntity,
                    StandardCharsets.UTF_8);
                Response<T> response = readResponse(responseString);

                if (response.getOk()) {
                    return response.getResult();
                }

                throw new BotException(response.getErrorDescription());
            }
        }
    }

    protected abstract HttpEntity createBody() throws IOException;

    protected abstract Response<T> readResponse(String content) throws IOException;

    protected static void addObjectBody(MultipartEntityBuilder builder, String name, Object content)
    {
        if (content instanceof InputStream) {
            builder.addBinaryBody(name, (InputStream) content);
        } else if (content instanceof File) {
            builder.addBinaryBody(name, (File) content);
        } else {
            builder.addTextBody(name, content.toString(), ContentType.TEXT_PLAIN);
        }
    }

}
