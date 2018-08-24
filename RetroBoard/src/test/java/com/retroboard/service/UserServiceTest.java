package com.retroboard.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.retroboard.domain.User;
import com.retroboard.repository.UserRepository;
import com.retroboard.service.UserService;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@MockBean
	private UserRepository userRepository;
	
	private UserService userService;
	
	@Before
	public void init() {
		this.userService = new UserService(userRepository);
	}
	
	@Test
	public void getAllCommentsForToday_HappyPath_ShouldReturn1Comment() {
		
		// Given
		User user = new User();
		user.setUsername("vaibhav");
		user.setPassword("password");
		user.setRole("USER");
		
		when(userRepository.findByUsername("vaibhav")).thenReturn(user);
		
		// When
		UserDetails actual = userService.loadUserByUsername("vaibhav");
		
		// Then
		verify(userRepository, times(1)).findByUsername("vaibhav");
		
	}
}
