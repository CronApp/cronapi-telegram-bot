package cronapi.telegram.bots.methods;

import java.io.IOException;

public class PromoteChatMember extends JsonMethod<Boolean> {

    private String chatId;
    private Integer userId;
    private Boolean canChangeInformation;
    private Boolean canPostMessages;
    private Boolean canEditMessages;
    private Boolean canDeleteMessages;
    private Boolean canInviteUsers;
    private Boolean canRestrictMembers;
    private Boolean canPinMessages;
    private Boolean canPromoteMembers;

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getCanChangeInformation() {
        return canChangeInformation;
    }

    public void setCanChangeInformation(Boolean canChangeInformation) {
        this.canChangeInformation = canChangeInformation;
    }

    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    public void setCanPostMessages(Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
    }

    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    public void setCanEditMessages(Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
    }

    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    public void setCanDeleteMessages(Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
    }

    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    public void setCanInviteUsers(Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
    }

    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    public void setCanRestrictMembers(Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
    }

    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    public void setCanPinMessages(Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
    }

    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    public void setCanPromoteMembers(Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
    }

    protected Response<Boolean> readResponse(String content) throws IOException {
        return null;
    }
}