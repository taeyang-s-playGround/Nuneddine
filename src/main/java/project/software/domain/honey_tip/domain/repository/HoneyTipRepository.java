package project.software.domain.honey_tip.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.software.domain.honey_tip.domain.HoneyTip;

public interface HoneyTipRepository extends JpaRepository<HoneyTip, Long> {

}
