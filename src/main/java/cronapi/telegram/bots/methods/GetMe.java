package cronapi.telegram.bots.methods;


import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.User;

import java.io.IOException;

public class GetMe extends Method<User> {

    @Override
    protected Response<User> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<User>>() {
        });
    }
}
