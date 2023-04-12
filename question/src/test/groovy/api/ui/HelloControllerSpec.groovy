package api.ui


import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class HelloControllerSpec extends Specification {
    def mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build()

    void setup() {
        Objects.requireNonNull(mockMvc)
    }

    def '[GET: /hello] "hello"를 반환한다.'() {
        given: '응답 정보'
        def 응답 = "Hello";

        when: 'GET 요청을 보내면'
        def 요청 = mockMvc.perform(get("/hello"))

        then: 'Hello 응답을 반환한다.'
        요청.andExpect(content().string(응답))
                .andExpect(status().isOk());
    }
}
