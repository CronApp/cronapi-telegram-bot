package cronapi.telegram.bots.models;

public class Chat {
    private Long id;
    private String type;
    private String title;
    private String firstName;
    private String lastName;
    private String username;
    private Boolean allMembersAreAdministrators;
    private ChatPhoto photo;
    private String description;
    private String inviteLink;
    private Message pinnedMessage;
    private String stickerSetName;
    private Message canSetStickerSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAllMembersAreAdministrators() {
        return allMembersAreAdministrators;
    }

    public void setAllMembersAreAdministrators(Boolean allMembersAreAdministrators) {
        this.allMembersAreAdministrators = allMembersAreAdministrators;
    }

    public ChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(ChatPhoto photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
    }

    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public void setPinnedMessage(Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    public String getStickerSetName() {
        return stickerSetName;
    }

    public void setStickerSetName(String stickerSetName) {
        this.stickerSetName = stickerSetName;
    }

    public Message getCanSetStickerSet() {
        return canSetStickerSet;
    }

    public void setCanSetStickerSet(Message canSetStickerSet) {
        this.canSetStickerSet = canSetStickerSet;
    }
}