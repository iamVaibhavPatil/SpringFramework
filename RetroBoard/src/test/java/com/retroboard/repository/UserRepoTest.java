package com.retroboard.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.retroboard.domain.User;
import com.retroboard.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findByUsername_HappyPath_ShouldReturn1User() throws Exception {
		
		// Given
		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("password");
		user.setRole("USER");
		testEntityManager.persist(user);
		testEntityManager.flush();
		
		// When
		User actual = userRepository.findByUsername("vaibhav");
		
		// Then
		assertThat(actual).isEqualTo(user);
	}
	
	@Test
	public void save_HappyPath_ShouldSave1User() throws Exception {
		
		// Given
		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("password");
		user.setRole("USER");

		// When
		User actual = userRepository.save(user);
		
		// Then
		assertThat(actual).isNotNull();
		assertThat(actual.getId()).isNotNull();
	}	
}
