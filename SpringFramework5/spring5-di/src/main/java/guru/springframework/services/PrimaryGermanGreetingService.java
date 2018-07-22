package guru.springframework.services;

public class PrimaryGermanGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;

	public PrimaryGermanGreetingService(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayGreeting() {
		return greetingRepository.getGermanGreeting();
	}

}
