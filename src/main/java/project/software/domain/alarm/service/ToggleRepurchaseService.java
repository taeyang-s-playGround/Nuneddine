package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.alarm.exception.AlarmNotFoundException;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ToggleRepurchaseService {

    private final AlarmRepository alarmRepository;

    public void execute(Long alarmId) {
        Alarm alarm = alarmRepository.findById(alarmId)
            .orElseThrow(() -> AlarmNotFoundException.EXCEPTION);

        alarm.toggleRepurchase(); // 도메인 메서드로 토글
    }
}