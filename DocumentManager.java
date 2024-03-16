import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
