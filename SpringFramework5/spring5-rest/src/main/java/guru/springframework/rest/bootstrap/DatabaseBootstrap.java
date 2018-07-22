package guru.springframework.rest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.rest.domain.Category;
import guru.springframework.rest.domain.Customer;
import guru.springframework.rest.respository.CategoryRepository;
import guru.springframework.rest.respository.CustomerRepository;

@Component
public class DatabaseBootstrap implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;

	public DatabaseBootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		loadCustomersData();
		loadCategoriesData();
	}

	private void loadCategoriesData() {
		
		Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count());
	}

	private void loadCustomersData() {

		Customer john = new Customer();
		john.setFirstName("John");
		john.setLastName("Doe");

		Customer ann = new Customer();
		ann.setFirstName("Ann");
		ann.setLastName("Boler");
		
		customerRepository.save(john);
		customerRepository.save(ann);
		
		System.out.println("Data Loaded =" + customerRepository.count());
	}
}
