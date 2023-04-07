package com.example.project;

import com.example.project.entity.Member;
import com.example.project.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private MemberRepository userRepository;


	@Test
	void insertUser() {
		Member user = Member.builder().id("tester").pw("1234").build();
		userRepository.save(user);
	}

	@Test
	void updateuser() {
		Optional<Member> userOptional = userRepository.findById("tester");
		if (userOptional.isPresent()) {
			Member user = userOptional.get();
			user.setPw("2222");
			userRepository.save(user);
		}
	}
}
