package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.Ad;
import pl.webcache.swexpads.domain.AdDetails;
import pl.webcache.swexpads.domain.AdItem;
import pl.webcache.swexpads.exceptions.AdNotFoundException;
import pl.webcache.swexpads.repositories.IAdDetailsRepository;
import pl.webcache.swexpads.repositories.IAdItemRepository;
import pl.webcache.swexpads.repositories.IAdRepository;

@Service
public class AdItemService {

	@Autowired
	private IAdDetailsRepository adDetailsRepository;

	@Autowired
	private IAdItemRepository adItemRepository;

	@Autowired
	private IAdRepository adRepository;

	public AdItem adAdItem(String adIdentifier, AdItem adItem) {
		try {
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
		} catch (Exception e) {
			throw new AdNotFoundException("Ad not found.");
		}
	}

	public Iterable<AdItem> findAdDetailsById(String id) {
		Ad ad = adRepository.findByIdentifier(id);
		if (ad == null) {
			throw new AdNotFoundException(String.format("Ad with identifier %s does not exist.", id));
		}

		return adItemRepository.findByAdIdentifierOrderByPriority(id);
	}

	public AdItem findByAdSequence(String adDetailsId, String adItemId) {

		AdDetails adDetails = adDetailsRepository.findByAdIdentifier(adDetailsId);
		if (adDetails == null) {
			throw new AdNotFoundException(String.format("Ad with identifier %s does not exist.", adDetailsId));
		}

		AdItem adItem = adItemRepository.findByAdSequence(adItemId);
		if (adItem == null) {
			throw new AdNotFoundException(String.format("Ad item with identifier %s does not exist.", adItemId));
		}

		if (!adItem.getAdIdentifier().equals(adDetailsId)) {
			throw new AdNotFoundException(String.format("Ad item %s doesn not exist in ad %s.", adItemId, adDetailsId));
		}

		return adItem;
	}

	public AdItem updateByAdSequence(AdItem updatedAdItem, String adDetailsId, String addItemId) {
		AdItem adItem = findByAdSequence(adDetailsId, addItemId);
		adItem = updatedAdItem;
		return adItemRepository.save(adItem);
	}

	public void deleteAdItemByAdSequence(String adDetailsId, String adItemId) {
		AdItem adItem = findByAdSequence(adDetailsId, adItemId);
		adItemRepository.delete(adItem);
	}
}
