package pl.webcache.swexpads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.webcache.swexpads.domain.Add;
import pl.webcache.swexpads.exceptions.AddIdException;
import pl.webcache.swexpads.repositories.IAddRepository;

@Service
public class AddService {

	@Autowired
	private IAddRepository addRepository;

	public Add saveOrUpdateAdd(Add add) {
		try {
			add.setIdentifier(add.getIdentifier().toUpperCase());
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

}
