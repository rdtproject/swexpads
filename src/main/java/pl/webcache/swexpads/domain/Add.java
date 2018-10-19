package pl.webcache.swexpads.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Add {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false, unique = true)
	private String identifier;
	@NotBlank(message = "Add subject cannot be empty")
	@Size(min = 5, max = 200, message = "Subject can have from 10 to 2000 characters")
	private String subject;
	@NotBlank(message = "Add text cannot be empty")
	private String text;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date creationDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date modificationDate;

	public Add() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.modificationDate = new Date();
	}
}