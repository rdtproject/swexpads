package pl.webcache.swexpads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.AdDetails;

@Repository
public interface IAdDetailsRepository extends CrudRepository<AdDetails, Long> {
	AdDetails findByAdIdentifier(String identifier);
}
