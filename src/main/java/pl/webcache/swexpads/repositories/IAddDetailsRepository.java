package pl.webcache.swexpads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.AddDetails;

@Repository
public interface IAddDetailsRepository extends CrudRepository<AddDetails, Long> {
	AddDetails findByAddIdentifier(String identifier);
}
