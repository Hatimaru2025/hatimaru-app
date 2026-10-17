package com.hatimaru.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void todoCanBeSaved() {
		TodoRepository repository = mock(TodoRepository.class);
		when(repository.findById(null)).thenReturn(null);
	}

}
