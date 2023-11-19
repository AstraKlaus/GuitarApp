package ak.spring.repositories;

import ak.spring.models.Person;
import org.glassfish.grizzly.utils.ObjectPool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String c);
}
