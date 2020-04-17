package com.file;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fileread.FileReadApplication;

@SpringBootTest(classes = FileReadApplication.class)
class FileReadApplicationTests {

	String expect="good";
	@Test
	void contextLoads() {
		assertEquals("good",expect);
	}

}
