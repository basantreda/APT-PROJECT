package com.collaborative.texteditor.texteditor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByOwner(String owner);
    List<Document> findBySharedWith(String sharedWith);
}