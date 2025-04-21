package project.software.domain.alarm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.alarm.controller.dto.request.SetAlarmRequest;
import project.software.domain.alarm.service.SetAlarmService;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final SetAlarmService setAlarmService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void setAlarm(@RequestBody SetAlarmRequest request) {
        setAlarmService.execute(request);
    }
}
