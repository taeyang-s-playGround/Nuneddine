package project.software.domain.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.software.domain.user.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    Boolean existsByAccountId(String accountId);

}
