package cronapi.telegram.bots.models;

import java.util.List;

public class UserProfilePhotos {

    private Integer totalCount;
    private List<List<PhotoSize>> photos;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<List<PhotoSize>> getPhotos() {
        return photos;
    }

    public void setPhotos(List<List<PhotoSize>> photos) {
        this.photos = photos;
    }
}