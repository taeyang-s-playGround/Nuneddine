package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.alarm.controller.dto.response.AlarmListResponse;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllAlarmService {
    private final UserFacade userFacade;
    private final AlarmRepository alarmRepository;

    public AlarmListResponse execute() {
        User user = userFacade.getCurrentUser();
        List<Alarm> alarmList = alarmRepository.findAllByUserId(user.getId());

        return AlarmListResponse.from(alarmList);
    }
}
