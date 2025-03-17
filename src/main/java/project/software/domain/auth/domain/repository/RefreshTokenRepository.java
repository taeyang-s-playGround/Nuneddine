package project.software.domain.auth.domain.repository;

import org.springframework.data.repository.CrudRepository;
import project.software.domain.auth.domain.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}
