package cronapi.telegram.bots.models;

public class ForceReply implements ReplyMarkup {
    private Boolean forceReply;
    private Boolean selective;

    public Boolean getForceReply() {
        return forceReply;
    }

    public void setForceReply(Boolean forceReply) {
        this.forceReply = forceReply;
    }

    public Boolean getSelective() {
        return selective;
    }

    public void setSelective(Boolean selective) {
        this.selective = selective;
    }
}