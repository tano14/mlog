package ar.com.tano.mlog.domain;

import java.util.Date;

public class MLogDTO {
	private Long id;
	private String title;
	private String content;
	private Date publicationDate;
	private Date modificationDate;
	private String categories;
	private byte[] mainImage;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public byte[] getMainImage() {
		return mainImage;
	}
	public void setMainImage(byte[] mainImage) {
		this.mainImage = mainImage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
