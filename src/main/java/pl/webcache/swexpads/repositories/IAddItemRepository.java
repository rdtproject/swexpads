package pl.webcache.swexpads.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.webcache.swexpads.domain.AddItem;

@Repository
public interface IAddItemRepository extends CrudRepository<AddItem, Long> {

	List<AddItem> findByAddIdentifierOrderByPriority(String id);

}
