package fr.wildcodeschool.seeknwild.Repository;

import fr.wildcodeschool.seeknwild.Model.Find;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FindRepository extends JpaRepository<Find, Long> {
}
