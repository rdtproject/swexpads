package pl.webcache.swexpads.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AddDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence = 0;
	private String addIdentifier;

	// one to one with add
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "add_id", nullable = false)
	@JsonIgnore
	private Add add;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "adDetails")
	private List<AddItem> addItems = new ArrayList<AddItem>();

	public AddDetails() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPTSequence() {
		return PTSequence;
	}

	public void setPTSequence(Integer pTSequence) {
		PTSequence = pTSequence;
	}

	public String getAddIdentifier() {
		return addIdentifier;
	}

	public void setAddIdentifier(String addIdentifier) {
		this.addIdentifier = addIdentifier;
	}

	public Add getAdd() {
		return add;
	}

	public void setAdd(Add add) {
		this.add = add;
	}

	public List<AddItem> getAddItems() {
		return addItems;
	}

	public void setAddItems(List<AddItem> addItems) {
		this.addItems = addItems;
	}

}
