import java.util.HashMap;

public class Document {
    private String documentName;
    private String content;
    private String owner;
    private HashMap<String, String> sharedUsers; // Username -> Permission (viewer/editor)

    public Document(String documentName, String owner) {
        if (documentName == null || documentName.isEmpty()) {
            throw new IllegalArgumentException("Document name cannot be null or empty.");
        }
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be null or empty.");
        }

        this.documentName = documentName;
        this.owner = owner;
        this.content = "";
        this.sharedUsers = new HashMap<>();
    }

    // Getters and setters
    public String getDocumentName() {
        return documentName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public HashMap<String, String> getSharedUsers() {
        return sharedUsers;
    }

    public void shareDocument(String username, String permission) {
        if (username != null && !username.isEmpty()) {
            sharedUsers.put(username, permission);
        } else {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
    }

    public void unshareDocument(String username) {
        if (sharedUsers.containsKey(username)) {
            sharedUsers.remove(username);
        } else {
            throw new IllegalArgumentException("Username not found in shared users.");
        }
    }
}
