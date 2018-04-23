package cronapi.telegram.bots.methods;

import com.fasterxml.jackson.core.type.TypeReference;
import cronapi.telegram.bots.models.UserProfilePhotos;
import java.io.IOException;

public class GetUserProfilePhotos extends JsonMethod<UserProfilePhotos> {

    private Integer userId;
    private Integer offset;
    private Integer limit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    protected Response<UserProfilePhotos> readResponse(String content) throws IOException {
        return OBJECT_MAPPER.readValue(content, new TypeReference<Response<UserProfilePhotos>>() {
        });
    }
}