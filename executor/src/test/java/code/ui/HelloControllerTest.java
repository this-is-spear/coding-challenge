package code.ui;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureWebMvc
@WebMvcTest(HelloController.class)
class HelloControllerTest {
	private static final String RESPONSE = "Hello";
	@Autowired
	protected MockMvc mockMvc;

	@Test
	void sayHello() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(content().string(RESPONSE))
			.andExpect(status().isOk());
	}
}
