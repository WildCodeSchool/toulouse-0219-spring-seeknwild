package fr.wildcodeschool.seeknwild.Repository;

import fr.wildcodeschool.seeknwild.Model.User;
import fr.wildcodeschool.seeknwild.Model.UserAdventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String text);
}
