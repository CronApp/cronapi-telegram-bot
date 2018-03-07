package cronapi.telegram.bots.models;

public class Sticker {
    private String fileId;
    private Integer width;
    private Integer height;
    private PhotoSize thumb;
    private Integer fileSize;
    private String emoji;
    private String setName;
    private String maskPosition;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(PhotoSize thumb) {
        this.thumb = thumb;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getMaskPosition() {
        return maskPosition;
    }

    public void setMaskPosition(String maskPosition) {
        this.maskPosition = maskPosition;
    }
}