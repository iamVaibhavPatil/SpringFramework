package com.pharmachain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmachain.domain.StoreUser;
import com.pharmachain.dto.StoreUserDTO;
import com.pharmachain.mapper.StoreUserMapper;
import com.pharmachain.repository.StoreUserRepository;
import com.pharmachain.security.JwtTokenProvider;

import reactor.core.publisher.Mono;

@Service
public class AuthService {

	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private StoreUserRepository userRepository;
	
	@Autowired
	private StoreUserMapper storeUserMapper;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Mono<StoreUserDTO> authenticateUser(StoreUserDTO storeUserDTO) {
		return userRepository.findByUserNameIgnoreCase(storeUserDTO.getUserName()).flatMap(user -> {
			StoreUserDTO userDTOResponse = storeUserMapper.storeUserToStoreUserDTO(user);
			if(passwordEncoder.matches(storeUserDTO.getPassword(), user.getPassword())) {
				userDTOResponse.setJwtToken(jwtTokenProvider.generateToken(user));
			}
			return Mono.just(userDTOResponse);
		});
	}
	
	@Transactional
	public Mono<StoreUserDTO> registerUser(StoreUserDTO storeUserDTO) {
		StoreUser user = storeUserMapper.storeUserDTOToStoreUser(storeUserDTO);
		user.setStoreUserId(sequenceService.getNextSequenceId(SequenceService.USER_SEQ_KEY));
		user.setPassword(passwordEncoder.encode(storeUserDTO.getPassword()));
		Mono<StoreUser> savedUser = userRepository.save(user);
		return savedUser.flatMap(u -> {
			StoreUserDTO uDTO = storeUserMapper.storeUserToStoreUserDTO(u);
			return Mono.just(uDTO);
		});
	}
}
