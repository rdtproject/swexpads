package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.Add;
import pl.webcache.swexpads.domain.AddDetails;
import pl.webcache.swexpads.exceptions.AddIdException;
import pl.webcache.swexpads.repositories.IAddDetailsRepository;
import pl.webcache.swexpads.repositories.IAddRepository;

@Service
public class AddService {

	@Autowired
	private IAddRepository addRepository;

	@Autowired
	private IAddDetailsRepository addDetailsRepository;

	public Add saveOrUpdateAdd(Add add) {
		try {
			add.setIdentifier(add.getIdentifier().toUpperCase());

			if (add.getId() == null) {
				AddDetails addDetails = new AddDetails();
				addDetails.setAdd(add);
				add.setAddDetails(addDetails);
				addDetails.setAddIdentifier(add.getIdentifier().toUpperCase());
			}

			if (add.getId() != null) {
				add.setAddDetails(addDetailsRepository.findByAddIdentifier(add.getIdentifier().toUpperCase()));
			}

			return addRepository.save(add);
		} catch (Exception e) {
			throw new AddIdException(String.format("Add ID '%s' already exists", add.getIdentifier().toUpperCase()));
		}
	}

	public Add findAddByIdentifier(String identifier) {
		Add add = addRepository.findByIdentifier(identifier);
		if (add == null) {
			throw new AddIdException(String.format("Add with Identifier '%s' does not exist.", identifier));
		}

		return addRepository.findByIdentifier(identifier.toUpperCase());
	}

	public Iterable<Add> findAllAdds() {
		return addRepository.findAll();
	}

	public void deleteAddByIdentifier(String identifier) {
		Add add = addRepository.findByIdentifier(identifier);
		if (add == null) {
			throw new AddIdException(
					String.format("Cannot delete Add with Identifier '%s'. This Add does not exist.", identifier));
		}
		addRepository.delete(add);
	}

}
