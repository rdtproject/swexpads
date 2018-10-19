package pl.webcache.swexpads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.Add;

@Repository
public interface IAddRepository extends CrudRepository<Add, Long> {

	Add findByIdentifier(String identifier);

	@Override
	Iterable<Add> findAll();

}
