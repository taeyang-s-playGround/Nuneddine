package project.software.domain.alarm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.alarm.controller.dto.request.UpdateAlarmRequest;
import project.software.domain.alarm.domain.Alarm;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.alarm.exception.AlarmNotFoundException;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.user.domain.User;
import project.software.infra.fcm.FCMService;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateAlarmService {

    private final AlarmRepository alarmRepository;
    private final FCMService fcmService;
    private final UserFacade userFacade;

    public void execute(Long alarmId, UpdateAlarmRequest request) {

        User user = userFacade.getCurrentUser();

        Alarm alarm = alarmRepository.findById(alarmId)
            .orElseThrow(() -> AlarmNotFoundException.EXCEPTION);

        alarm.updateAlarm(request.getName(), request.getDateType(), request.getStartTime(), request.getEndTime());

        if (request.getEndTime() != null) {
            fcmService.sendMessageLater(user.getDeviceToken(), request.getName()+"을 교체할 시간이예요!", "눈 건강을 위해 새 렌즈로 바꿔주세요", 1L);
        }
    }
}
