package fr.wildcodeschool.seeknwild.Repository;

import fr.wildcodeschool.seeknwild.Model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long> {
}
