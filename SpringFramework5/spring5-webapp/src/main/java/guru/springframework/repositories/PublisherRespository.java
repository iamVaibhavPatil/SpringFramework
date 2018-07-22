package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.model.Publisher;

public interface PublisherRespository extends CrudRepository<Publisher, Long>{

}
