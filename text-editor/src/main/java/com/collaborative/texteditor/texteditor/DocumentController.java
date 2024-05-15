package com.collaborative.texteditor.texteditor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/owned")
    public ResponseEntity<List<Document>> getOwnedDocuments(@RequestParam String owner) {
        return ResponseEntity.ok(documentService.findDocumentsByOwner(owner));
    }

    @GetMapping("/shared")
    public ResponseEntity<List<Document>> getSharedDocuments(@RequestParam String sharedWith) {
        return ResponseEntity.ok(documentService.findDocumentsSharedWith(sharedWith));
    }

    @PostMapping("/create")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        return ResponseEntity.ok(documentService.createDocument(document));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document) {
        return ResponseEntity.ok(documentService.updateDocument(document));
    }
}