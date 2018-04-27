package cronapi.telegram.bots.models;

public abstract class InputMedia {

    private final String type;
    private Object media;
    private String caption;
    private String parseMode;

    protected InputMedia(String type)
    {
        this.type = type;
    }

    public Object getMedia() {
        return media;
    }

    public void setMedia(Object media) {
        this.media = media;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(String parseMode) {
        this.parseMode = parseMode;
    }

    public String getType() {
        return type;
    }
}