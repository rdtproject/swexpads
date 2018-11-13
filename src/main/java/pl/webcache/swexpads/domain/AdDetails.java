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
public class AdDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer PTSequence = 0;
	private String adIdentifier;

	// one to one with ad
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ad_id", nullable = false)
	@JsonIgnore
	private Ad ad;

	@OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "adDetails", orphanRemoval = true)
	private List<AdItem> adItems = new ArrayList<AdItem>();

	public AdDetails() {
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

	public String getAdIdentifier() {
		return adIdentifier;
	}

	public void setAdIdentifier(String adIdentifier) {
		this.adIdentifier = adIdentifier;
	}

	public Ad getAd() {
		return ad;
	}

	public void setAd(Ad ad) {
		this.ad = ad;
	}

	public List<AdItem> getAdItems() {
		return adItems;
	}

	public void setAdItems(List<AdItem> adItems) {
		this.adItems = adItems;
	}

}
