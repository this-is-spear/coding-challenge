package docs.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.test.web.servlet.MockMvc;

import api.QuestionApplication;
import docs.TestTemplate;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest(classes = QuestionApplication.class)
public class QuestionDocumentation extends TestTemplate {
	@Autowired
	protected MockMvc mockMvc;

	protected OperationRequestPreprocessor getDocumentRequest() {
		return Preprocessors.preprocessRequest(
			Preprocessors.modifyUris()
				.scheme("http")
				.host("127.0.0.1")
				.port(8081),
			Preprocessors.prettyPrint()
		);
	}

	protected OperationResponsePreprocessor getDocumentResponse() {
		return Preprocessors.preprocessResponse(Preprocessors.prettyPrint());
	}
}
