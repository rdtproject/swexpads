package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.AdDetails;
import pl.webcache.swexpads.domain.AdItem;
import pl.webcache.swexpads.repositories.IAdDetailsRepository;
import pl.webcache.swexpads.repositories.IAdItemRepository;

@Service
public class AdItemService {

	@Autowired
	private IAdDetailsRepository adDetailsRepository;

	@Autowired
	private IAdItemRepository adItemRepository;

	public AdItem adAdItem(String adIdentifier, AdItem adItem) {
		AdDetails adDetails = adDetailsRepository.findByAdIdentifier(adIdentifier);
		adItem.setAdDetails(adDetails);
		adItem.setAdIdentifier(adIdentifier);

		Integer adDetailsSequence = adDetails.getPTSequence();
		adDetailsSequence++;
		adDetails.setPTSequence(adDetailsSequence);

		// add sequence
		adItem.setAdSequence(adDetails.getAdIdentifier() + "-" + adDetailsSequence);		

		// set up initial priority if it was not set
		if (adItem.getPriority() == null) {
			adItem.setPriority(3);
		}

		if (adItem.getStatus() == "" || adItem.getStatus() == null) {
			adItem.setStatus("TO_DO");
		}

		return adItemRepository.save(adItem);
	}
	
	public Iterable<AdItem> findAdDetailsById(String id) {
		return adItemRepository.findByAdIdentifierOrderByPriority(id);
	}
}
