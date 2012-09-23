package org.daneking.search;

import org.apache.commons.lang.StringUtils;
import org.daneking.document.DocumentController;
import org.daneking.document.DocumentModel;
import org.daneking.domain.Document;
import org.daneking.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/searchView")
public class SearchController {
	private static final String SEARCH_VIEW = "searchView";
	@Autowired
	private DocumentService service;

	//this should forward to document controller
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView findDocument(SearchRequest request) {
		Document document = getDocument(request);
		if(document==null){
			ModelAndView mav = new ModelAndView(SEARCH_VIEW,
					"message","Not Found");
			return mav;
		}
		ModelAndView mav = new ModelAndView(DocumentController.DOCUMENT_VIEW,
				DocumentController.DOCUMENT_KEY, new DocumentModel(document));
		return mav;
	}

	private Document getDocument(SearchRequest request) {
		Document document=null;
		if(request.getId()!=null){
			document = service.findDocumentById(request.getId());
		}else if(StringUtils.isNotBlank(request.getTerm())){
			document = service.findDocumentByContent(request.getTerm());
		}
		return document;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loadSearchForm(SearchRequest request) {
		return SEARCH_VIEW;
	}
	
}
