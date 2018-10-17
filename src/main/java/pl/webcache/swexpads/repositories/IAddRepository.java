package pl.webcache.swexpads.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.Add;

@Repository
public interface IAddRepository extends CrudRepository<Add, Long> {

	@Override
	Iterable<Add> findAllById(Iterable<Long> ids);

}
