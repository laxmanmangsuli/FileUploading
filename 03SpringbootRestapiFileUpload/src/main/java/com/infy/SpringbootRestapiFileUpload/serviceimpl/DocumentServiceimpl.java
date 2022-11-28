package com.infy.SpringbootRestapiFileUpload.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.SpringbootRestapiFileUpload.model.Document;
import com.infy.SpringbootRestapiFileUpload.repository.DocumentRepository;
import com.infy.SpringbootRestapiFileUpload.servicei.DocumentServicei;
@Service
public class DocumentServiceimpl implements DocumentServicei {
	
	@Autowired
	DocumentRepository dr;

	@Override
	public void fileUpload(Document d) {
		dr.save(d);
		
	}

	@Override
	public List<Document> getDocument() {
		
		return dr.findAll();
	}

	@Override
	public void deleteDocument(Integer documentId) {
		dr.deleteById(documentId);
		
	}

	@Override
	public void updateDocument(Integer documentId, Document d) {
					Optional<Document> op=dr.findById(documentId);
					
					if(op.isPresent())
					{
						Document document=op.get();
						document.setCustId(d.getCustId());
						document.setPhoto(d.getPhoto());
						document.setSignature(d.getSignature());
						document.setPancard(d.getPancard());
						dr.save(document);
					}
		
	}

	

}
