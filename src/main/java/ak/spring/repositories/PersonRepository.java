package ak.spring.repositories;

import ak.spring.models.Person;
import ak.spring.models.Song;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String c);

    Optional<Person> findByUuid(UUID uuid);

    @Query("SELECT s FROM Person p JOIN p.songs s WHERE p.uuid = :personUuid")
    Page<Song> findSongsByPersonUuid(@Param("personUuid") UUID personUuid, Pageable pageable);

}
