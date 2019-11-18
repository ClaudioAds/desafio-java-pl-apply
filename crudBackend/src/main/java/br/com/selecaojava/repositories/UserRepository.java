package br.com.selecaojava.repositories;

import br.com.selecaojava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{

}
