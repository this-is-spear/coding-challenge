package docs.question;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@DisplayName("[QuestionDocumentation] : hello controller 문서화")
public class HelloControllerDoc extends QuestionDocumentation {
	@Test
	void get__hello_요청() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(status().isOk())
			.andDo(document(
				"question/hello",
				getDocumentRequest(),
				getDocumentResponse()
			));
	}
}
