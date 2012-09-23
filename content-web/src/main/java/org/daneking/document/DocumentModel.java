package org.daneking.document;

import java.util.Collection;

import org.daneking.domain.Document;
import org.daneking.domain.Tag;

public class DocumentModel {

	private Document document = new Document();
	

	public Long getId(){
		return document.getId();
	}



	public Collection<Tag> getTags() {
		return document.getTags();
	}

	public void setTags(Collection<? extends Tag> tags) {
		document.getTags().addAll(tags);
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getContent() {
		return document.getContent();
	}

	public void setContent(String content) {
		document.setContent(content==null?"":content);
	}

	// Constructors
	public DocumentModel() {
	}

	public DocumentModel(Document document) {
		super();
		this.document = document == null ? new Document() : document;
	}

}
