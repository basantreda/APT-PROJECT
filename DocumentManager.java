import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Document class represents a text document
class Document {
    private String documentName;
    private String owner;
    private HashMap<String, String> sharedUsers; // Username -> Permission (viewer/editor)

    public Document(String documentName, String owner) {
        this.documentName = documentName;
        this.owner = owner;
        this.sharedUsers = new HashMap<>();
    }

    public String getDocumentName() {
        return documentName;
    }

    public String getOwner() {
        return owner;
    }

    public HashMap<String, String> getSharedUsers() {
        return sharedUsers;
    }

    public void shareDocument(String username, String permission) {
        sharedUsers.put(username, permission);
    }

    public void unshareDocument(String username) {
        sharedUsers.remove(username);
    }
}

// DocumentManager class manages documents (creation, deletion, etc.)
public class DocumentManager {
    private HashMap<String, Document> documents;

    public DocumentManager() {
        documents = new HashMap<>();
    }

    public void createDocument(String documentName, String owner) {
        if (!documents.containsKey(documentName)) {
            documents.put(documentName, new Document(documentName, owner));
            System.out.println("Document created successfully.");
        } else {
            System.out.println("Document name already exists. Please choose another name.");
        }
    }

    public void deleteDocument(String documentName, String username) {
        Document document = documents.get(documentName);
        if (document != null && document.getOwner().equals(username)) {
            documents.remove(documentName);
            System.out.println("Document deleted successfully.");
        } else {
            System.out.println("You are not authorized to delete this document.");
        }
    }

    public List<Document> getOwnedDocuments(String owner) {
        List<Document> ownedDocuments = new ArrayList<>();
        for (Document document : documents.values()) {
            if (document.getOwner().equals(owner)) {
                ownedDocuments.add(document);
            }
        }
        return ownedDocuments;
    }

    public List<Document> getSharedDocuments(String username) {
        List<Document> sharedDocuments = new ArrayList<>();
        for (Document document : documents.values()) {
            if (document.getSharedUsers().containsKey(username)) {
                sharedDocuments.add(document);
            }
        }
        return sharedDocuments;
    }

    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();
        manager.createDocument("Document1", "Alice");
        manager.createDocument("Document2", "Bob");

        List<Document> aliceDocuments = manager.getOwnedDocuments("Alice");
        List<Document> bobDocuments = manager.getOwnedDocuments("Bob");

        System.out.println("Alice's Documents:");
        for (Document doc : aliceDocuments) {
            System.out.println(doc.getDocumentName());
        }

        System.out.println("\nBob's Documents:");
        for (Document doc : bobDocuments) {
            System.out.println(doc.getDocumentName());
        }

        manager.deleteDocument("Document1", "Alice");
    }
}
