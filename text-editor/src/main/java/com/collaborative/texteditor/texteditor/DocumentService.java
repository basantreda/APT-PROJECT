package com.collaborative.texteditor.texteditor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    
    public List<Document> findDocumentsByOwner(String owner) {
        return documentRepository.findByOwner(owner);
    }

    public List<Document> findDocumentsSharedWith(String sharedWith) {
        return documentRepository.findBySharedWith(sharedWith);
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public Document updateDocument(Document document) {
        return documentRepository.save(document);
    }
}