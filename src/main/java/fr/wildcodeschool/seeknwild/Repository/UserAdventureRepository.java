package fr.wildcodeschool.seeknwild.Repository;

import fr.wildcodeschool.seeknwild.Model.UserAdventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdventureRepository extends JpaRepository<UserAdventure, Long> {
}
