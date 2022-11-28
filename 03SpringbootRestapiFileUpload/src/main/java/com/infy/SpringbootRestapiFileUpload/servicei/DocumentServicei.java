package com.infy.SpringbootRestapiFileUpload.servicei;

import java.util.List;
import java.util.Optional;

import com.infy.SpringbootRestapiFileUpload.model.Document;

public interface DocumentServicei {

	public void fileUpload(Document d);

	public List<Document> getDocument();

	public void deleteDocument(Integer documentId);


	public void updateDocument(Integer documentId, Document d);

}
