package project.software.domain.alarm.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.software.domain.alarm.domain.Alarm;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
}
