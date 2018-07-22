package guru.springframework.rest.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.rest.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
