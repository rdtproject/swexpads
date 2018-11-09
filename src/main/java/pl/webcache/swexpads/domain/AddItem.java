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
public class AddItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(updatable = false)
	private String addSequence;
	@NotBlank(message = "Please include a project summary")
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	private Date dueDate;

	// ManyToOne with AddDetails
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "add_details_id", updatable = false, nullable = false)
	@JsonIgnore
	private AddDetails adDetails;

	@Column(updatable = false)
	private String addIdentifier;

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

	public String getAddSequence() {
		return addSequence;
	}

	public void setAddSequence(String addSequence) {
		this.addSequence = addSequence;
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

	public String getAddIdentifier() {
		return addIdentifier;
	}

	public void setAddIdentifier(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

	public AddDetails getAdDetails() {
		return adDetails;
	}

	public void setAdDetails(AddDetails adDetails) {
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
		return "AddItem [id=" + id + ", addSequence=" + addSequence + ", summary=" + summary + ", acceptanceCriteria="
				+ acceptanceCriteria + ", status=" + status + ", priority=" + priority + ", dueDate=" + dueDate
				+ ", addIdentifier=" + addIdentifier + ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate + "]";
	}

}
