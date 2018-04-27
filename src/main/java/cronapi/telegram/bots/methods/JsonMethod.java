package cronapi.telegram.bots.methods;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

public abstract class JsonMethod<T> extends Method<T> {

    @Override
    protected HttpEntity createBody() throws IOException {
        return new StringEntity(OBJECT_MAPPER.writeValueAsString(this),
            ContentType.APPLICATION_JSON);
    }
}
