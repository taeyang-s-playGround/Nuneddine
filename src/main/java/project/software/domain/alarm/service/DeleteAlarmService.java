package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.alarm.domain.repository.AlarmRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteAlarmService {
    private final AlarmRepository alarmRepository;

    public void execute(Long alarmId) {
        alarmRepository.deleteById(alarmId);
    }
}
