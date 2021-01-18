package com.ishwor.newp.spring.boot.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Embeddable
public class Doc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doc_id;

	private String docName;
	private String docType;

	@Lob
	private byte[] data;

	public Doc() {

	}

	public Doc(String docName, String docType, byte[] data) {
		this.docType = docType;
		this.docName = docName;
		this.data = data;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
