package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.Update;

import java.io.IOException;
import java.util.List;

public class GetUpdates extends Method<List<Update>> {

    @Override
    protected Response<List<Update>> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<List<Update>>>() {
        });
    }
}
