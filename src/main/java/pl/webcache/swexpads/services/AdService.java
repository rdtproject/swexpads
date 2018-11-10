package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.Ad;
import pl.webcache.swexpads.domain.AdDetails;
import pl.webcache.swexpads.exceptions.AdIdException;
import pl.webcache.swexpads.repositories.IAdDetailsRepository;
import pl.webcache.swexpads.repositories.IAdRepository;

@Service
public class AdService {

	@Autowired
	private IAdRepository adRepository;

	@Autowired
	private IAdDetailsRepository adDetailsRepository;

	public Ad saveOrUpdateAd(Ad ad) {
		try {
			ad.setIdentifier(ad.getIdentifier().toUpperCase());

			if (ad.getId() == null) {
				AdDetails adDetails = new AdDetails();
				adDetails.setAd(ad);
				ad.setAdDetails(adDetails);
				adDetails.setAdIdentifier(ad.getIdentifier().toUpperCase());
			}

			if (ad.getId() != null) {
				ad.setAdDetails(adDetailsRepository.findByAdIdentifier(ad.getIdentifier().toUpperCase()));
			}

			return adRepository.save(ad);
		} catch (Exception e) {
			throw new AdIdException(String.format("Ad ID '%s' already exists", ad.getIdentifier().toUpperCase()));
		}
	}

	public Ad findAdByIdentifier(String identifier) {
		Ad ad = adRepository.findByIdentifier(identifier);
		if (ad == null) {
			throw new AdIdException(String.format("Ad with Identifier '%s' does not exist.", identifier));
		}

		return adRepository.findByIdentifier(identifier.toUpperCase());
	}

	public Iterable<Ad> findAllAds() {
		return adRepository.findAll();
	}

	public void deleteAddByIdentifier(String identifier) {
		Ad ad = adRepository.findByIdentifier(identifier);
		if (ad == null) {
			throw new AdIdException(
					String.format("Cannot delete Ad with Identifier '%s'. This Ad does not exist.", identifier));
		}
		adRepository.delete(ad);
	}

}
