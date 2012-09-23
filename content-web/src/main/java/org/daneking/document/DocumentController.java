package org.daneking.document;

import org.daneking.domain.Document;
import org.daneking.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/document")
public class DocumentController {
	public static final String DOCUMENT_KEY = "document";
	public static final String DOCUMENT_VIEW = "documentView";
	
	public void setDocumentService(DocumentService service) {
		this.service = service;
	}

	@Autowired
	private DocumentService service;

@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public ModelAndView getDocument(@PathVariable Long id){
		Document document=service.findDocumentById(id);
		ModelAndView mav=new ModelAndView(DOCUMENT_VIEW);
		mav.addObject(DOCUMENT_KEY, new DocumentModel(document));
		return mav;
	}
/*
 * todo create find by id
	
	@RequestMapping(method=RequestMethod.DELETE,value="document/{id}")
	public ModelAndView deleteDocument(@PathVariable String id){
		Status status=service.deleteDocument(id);
		mav.addObject("document", status);
		return mav;
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView saveDocument(DocumentModel document){

		Document repoDocument;

		repoDocument=service.saveDocument(document.getDocument());
		
		ModelAndView mav=new ModelAndView(DOCUMENT_VIEW,DOCUMENT_KEY,new DocumentModel(repoDocument) );
		mav.addObject("saved", String.format("Id is %s",repoDocument.getId()));
		return mav;
	}
	
	
	
}
