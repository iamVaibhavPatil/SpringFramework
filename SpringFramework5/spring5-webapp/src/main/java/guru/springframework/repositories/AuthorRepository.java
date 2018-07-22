package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
