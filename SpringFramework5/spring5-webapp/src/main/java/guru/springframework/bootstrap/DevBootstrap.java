package guru.springframework.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.model.Author;
import guru.springframework.model.Book;
import guru.springframework.model.Publisher;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.PublisherRespository;

/**
 * Load Data on Application Load - ApplicationListener
 * */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRespository publisherRespository; 
	
	//Constructor dependency injection
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRespository publisherRespository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRespository = publisherRespository;
	}

	private void initData() {
		
		Publisher wrox = new Publisher("Pack Publications", "123 Street, NY");
		Publisher kindle = new Publisher("Kindle Fire Publications", "123 Street, SF");
		publisherRespository.save(kindle);
		publisherRespository.save(wrox);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "2345", wrox);
		wrox.getBooks().add(ddd);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEjb = new Book("J2EE Development without EJB", "23445", kindle);
		kindle.getBooks().add(noEjb);
		rod.getBooks().add(noEjb);
		noEjb.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(noEjb);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
}
