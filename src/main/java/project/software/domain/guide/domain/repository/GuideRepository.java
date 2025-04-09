package project.software.domain.guide.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.guide.domain.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> {

}
