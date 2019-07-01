package fr.wildcodeschool.seeknwild.Repository;

import fr.wildcodeschool.seeknwild.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {

    User findUserByEmail(String text);
}
