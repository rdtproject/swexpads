package pl.webcache.swexpads.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.AdItem;

@Repository
public interface IAdItemRepository extends CrudRepository<AdItem, Long> {

	List<AdItem> findByAdIdentifierOrderByPriority(String id);

}
