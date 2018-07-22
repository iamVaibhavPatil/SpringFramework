package guru.springframework.rest.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.rest.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);
}
