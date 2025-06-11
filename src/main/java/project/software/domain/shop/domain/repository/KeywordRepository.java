package project.software.domain.shop.domain.repository;

import org.springframework.data.repository.CrudRepository;
import project.software.domain.shop.domain.Keyword;
import project.software.domain.user.domain.User;

import java.util.List;

public interface KeywordRepository extends CrudRepository<Keyword, Long> {
    List<Keyword> findAllByUser(User user);
}
