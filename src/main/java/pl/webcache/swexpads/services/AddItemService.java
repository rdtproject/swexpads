package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.AddDetails;
import pl.webcache.swexpads.domain.AddItem;
import pl.webcache.swexpads.repositories.IAddDetailsRepository;
import pl.webcache.swexpads.repositories.IAddItemRepository;

@Service
public class AddItemService {

	@Autowired
	private IAddDetailsRepository adDetailsRepository;

	@Autowired
	private IAddItemRepository adItemRepository;

	public AddItem addAdItem(String adIdentifier, AddItem adItem) {
		AddDetails adDetails = adDetailsRepository.findByAddIdentifier(adIdentifier);
		adItem.setAdDetails(adDetails);
		adItem.setAddIdentifier(adIdentifier);

		Integer adDetailsSequence = adDetails.getPTSequence();
		adDetailsSequence++;
		adDetails.setPTSequence(adDetailsSequence);

		// add sequence
		adItem.setAddSequence(adDetails.getAddIdentifier() + "-" + adDetailsSequence);		

		// set up initial priority if it was not set
		if (adItem.getPriority() == null) {
			adItem.setPriority(3);
		}

		if (adItem.getStatus() == "" || adItem.getStatus() == null) {
			adItem.setStatus("TO_DO");
		}

		return adItemRepository.save(adItem);
	}
	
	public Iterable<AddItem> findAdDetailsById(String id) {
		return adItemRepository.findByAddIdentifierOrderByPriority(id);
	}
}
