package pl.webcache.swexpads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.Ad;

@Repository
public interface IAdRepository extends CrudRepository<Ad, Long> {

	Ad findByIdentifier(String identifier);

	@Override
	Iterable<Ad> findAll();

}
