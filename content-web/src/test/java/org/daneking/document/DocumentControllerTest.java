package org.daneking.document;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.daneking.domain.Document;
import org.daneking.service.DocumentService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class DocumentControllerTest {
	private DocumentController controller=new DocumentController();
	private DocumentService service=mock(DocumentService.class);
	private static final Long NOT_FOUND_ID=9999L;
	private static final Long FOUND_ID=1L;
	@Test
	public void testGetDocumentShouldReturnDocumentView() {
		when(service.findDocumentById(NOT_FOUND_ID)).thenReturn(null);
		controller.setDocumentService(service);
		ModelAndView mav=controller.getDocument(NOT_FOUND_ID);
		assertThat("View should be Document",DocumentController.DOCUMENT_VIEW,equalTo(mav.getViewName()));
	}

	@Test
	public void testSaveDocumentShouldReturnDocumentView() {
		Document document=mock(Document.class);
		when(document.getId()).thenReturn(FOUND_ID);
		DocumentModel documentModel=new DocumentModel(document);
		
		
		when(service.saveDocument(document)).thenReturn(document);
		controller.setDocumentService(service);
		
		ModelAndView mav=controller.saveDocument(documentModel);
		assertThat("View should be Document",DocumentController.DOCUMENT_VIEW,equalTo(mav.getViewName()));
	}
	@Test
	public void testSaveDocumentShouldReturnSavedDocument() {
		Document document=mock(Document.class);
		when(document.getId()).thenReturn(FOUND_ID);
		DocumentModel documentModel=new DocumentModel(document);
		
		
		when(service.saveDocument(document)).thenReturn(document);
		controller.setDocumentService(service);
		
		ModelAndView mav=controller.saveDocument(documentModel);
		assertThat("View should be Document",DocumentController.DOCUMENT_VIEW,equalTo(mav.getViewName()));
	}
}
