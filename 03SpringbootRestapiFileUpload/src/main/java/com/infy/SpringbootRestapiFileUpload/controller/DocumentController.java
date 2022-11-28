package com.infy.SpringbootRestapiFileUpload.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.SpringbootRestapiFileUpload.model.Document;
import com.infy.SpringbootRestapiFileUpload.servicei.DocumentServicei;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
public class DocumentController {
	
	@Autowired
	DocumentServicei dsi;
	
	
	@PostMapping(value = "document",consumes =MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam (value = "photo",required = true) MultipartFile file,@RequestParam ("signature") MultipartFile file1,@RequestParam ("pancard") MultipartFile file2,@RequestPart("custId") String custId )
	{
//		log.info("File Type "+file.getContentType());
//		log.info("File orignal "+file.getOriginalFilename());
//		log.info("File name "+file.getName());
//		log.info("File size "+file.getSize());
//		log.error(null);
//		log.info("custId json",custId); //use in Company
//		log.info("custId json"+custId);
		try {
			log.info("Json "+custId);

			ObjectMapper om=new ObjectMapper();
			Document d = new Document();
			d.setPhoto(file.getBytes());
			d.setSignature(file.getBytes());
			d.setPancard(file.getBytes());
			
			Document doc = om.readValue(custId, Document.class);
			d.setCustId(doc.getCustId());
			log.info("Java "+doc);
			dsi.fileUpload(d);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "File Uploaded";
	}
	
	@GetMapping(value = "/document")
	public List<Document> getDocument()
	{
		List<Document>	list=dsi.getDocument();
			return list;
	}
	
	@PutMapping("/document/{documentId}")
	public String updateDocument(@PathVariable("documentId") Integer documentId,@RequestParam ("photo") MultipartFile file,@RequestParam ("signature") MultipartFile file1,@RequestParam ("pancard") MultipartFile file2,@RequestPart("custId") String custId)
	{
		
		try {
			log.info("Json "+custId);

			ObjectMapper om=new ObjectMapper();
			Document d = new Document();
			d.setPhoto(file.getBytes());
			d.setSignature(file.getBytes());
			d.setPancard(file.getBytes());
			
			Document doc = om.readValue(custId, Document.class);
			d.setCustId(doc.getCustId());
			log.info("Java "+doc);
			dsi.updateDocument(documentId,d);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Document update Successful..!";
	}
	
	@DeleteMapping("/document/{documentId}")
	public String deleteDocument(@PathVariable("documentId") Integer documentId)
	{
		dsi.deleteDocument(documentId);
		return "Delete successfull";
	}
	

}
