package br.com.example.webService.repositories;

import br.com.example.webService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByid(Long id);

    @Query(value = "select * from tb_user u where u.password = 123", nativeQuery = true)
    List<User> findAlluserPassword();
}
