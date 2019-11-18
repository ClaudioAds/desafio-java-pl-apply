package br.com.selecaojava;

import br.com.selecaojava.entities.User;
import br.com.selecaojava.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserEndPointTestIntegration {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class config{
        public RestTemplateBuilder restTemplateBuilder(){
            return new RestTemplateBuilder();
        }
    }

    @Test
    public void listUsersWhenUserForId(){
        ResponseEntity<String> response = testRestTemplate.getForEntity("/api/user/1", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void listUsersCorrects(){
        List<User> users = asList(new User("Cicero", "419.311.520-80", "claudio@hotmail.com", "M", new Date(02 / 05 / 2011), "Sãobentense", "Brasileiro"),
                new User("Mario", "437.864.340-50", "claudio@hotmail.com", "M", new Date(02 / 05 / 2011), "Sãobentense", "Brasileiro"));

        BDDMockito.when(userRepository.findAll()).thenReturn(users);
        ResponseEntity<String> response = testRestTemplate.getForEntity("/api/users", String.class);
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }
}
