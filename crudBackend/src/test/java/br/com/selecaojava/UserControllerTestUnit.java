package br.com.selecaojava;

import br.com.selecaojava.entities.User;
import br.com.selecaojava.repositories.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserControllerTestUnit {
    @Autowired
    private UserRepository userRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void creatUser(){
        User user = new User("Cláudio","437.864.340-50", "claudio@hotmail.com","M", new Date(02/05/2011),"Sãobentense", "Brasileiro");
        this.userRepository.save(user);
        assertThat(user.getNome()).isEqualTo("Cláudio");
        assertThat(user.getCpf()).isEqualTo("437.864.340-50");
        assertThat(user.getEmail()).isEqualTo("claudio@hotmail.com");
        assertThat(user.getSexo()).isEqualTo("M");
        assertThat(user.getDatanascimento()).isEqualTo(new Date(02/05/2011));
        assertThat(user.getNaturalidade()).isEqualTo("Sãobentense");
        assertThat(user.getNacionalidade()).isEqualTo("Brasileiro");

    }

    @Test
    public void deleteUser(){
        User user = new User("Cláudio","437.864.340-50", "claudio@hotmail.com","M", new Date(02/05/2011),"Sãobentense", "Brasileiro");
        this.userRepository.save(user);
        userRepository.delete(user);
        assertThat(userRepository.findById(user.getId())).isNotNull();
    }

    @Test
    public void updateUser(){
        User user = new User("Cláudio","437.864.340-50", "claudio@hotmail.com","M", new Date(02/05/2011),"Sãobentense", "Brasileiro");
        this.userRepository.save(user);
        user.setNome("Moacir");
        user.setEmail("moacir@gmail.com");
        this.userRepository.save(user);
        this.userRepository.findById(user.getId());
        assertThat(user.getNome()).isEqualTo("Moacir");
        assertThat(user.getEmail()).isEqualTo("moacir@gmail.com");
    }

}
