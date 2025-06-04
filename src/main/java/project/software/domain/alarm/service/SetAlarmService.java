package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.alarm.controller.dto.request.SetAlarmRequest;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;

@Service
@RequiredArgsConstructor
public class SetAlarmService {

    private final AlarmRepository alarmRepository;
    private final UserFacade userFacade;

    public void execute(SetAlarmRequest request) {
        User user = userFacade.getCurrentUser();

        alarmRepository.save(Alarm.builder()
            .name(request.getName())
            .dateType(request.getDateType())
            .user(user)
            .isRepurchased(false)
            .build()
        );
    }
}
