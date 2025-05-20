package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.alarm.controller.dto.request.UpdateAlarmRequest;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.alarm.exception.AlarmNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateAlarmService {

    private final AlarmRepository alarmRepository;

    public void execute(Long alarmId, UpdateAlarmRequest request) {
        Alarm alarm = alarmRepository.findById(alarmId)
            .orElseThrow(() -> AlarmNotFoundException.EXCEPTION);

        alarm.updateAlarm(request.getName(), request.getDateType(), request.getStartTime(), request.getEndTime());
    }
}
