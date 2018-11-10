package pl.webcache.swexpads.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AdItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private String adSequence;
	@NotBlank(message = "Please include a project summary")
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	private Date dueDate;

	// ManyToOne with AdDetails
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "ad_details_id", updatable = false, nullable = false)
	@JsonIgnore
	private AdDetails adDetails;

	@Column(updatable = false)
	private String adIdentifier;

	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column(updatable = false)
	private Date creationDate;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date modificationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdSequence() {
		return adSequence;
	}

	public void setAdSequence(String adSequence) {
		this.adSequence = adSequence;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAdIdentifier() {
		return adIdentifier;
	}

	public void setAdIdentifier(String adIdentifier) {
		this.adIdentifier = adIdentifier;
	}

	public AdDetails getAdDetails() {
		return adDetails;
	}

	public void setAdDetails(AdDetails adDetails) {
		this.adDetails = adDetails;
	}

	@PrePersist
	protected void onCreate() {
		this.creationDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.modificationDate = new Date();
	}

	@Override
	public String toString() {
		return "AdItem [id=" + id + ", adSequence=" + adSequence + ", summary=" + summary + ", acceptanceCriteria="
				+ acceptanceCriteria + ", status=" + status + ", priority=" + priority + ", dueDate=" + dueDate
				+ ", adDetails=" + adDetails + ", adIdentifier=" + adIdentifier + ", creationDate=" + creationDate
				+ ", modificationDate=" + modificationDate + "]";
	}

}
