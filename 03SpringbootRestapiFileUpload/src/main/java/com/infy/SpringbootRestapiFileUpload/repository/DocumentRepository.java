package com.infy.SpringbootRestapiFileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.SpringbootRestapiFileUpload.model.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
