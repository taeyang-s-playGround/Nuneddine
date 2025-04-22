package project.software.domain.alarm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.alarm.controller.dto.request.SetAlarmRequest;
import project.software.domain.alarm.controller.dto.response.AlarmListResponse;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.alarm.service.DeleteAlarmService;
import project.software.domain.alarm.service.GetAllAlarmService;
import project.software.domain.alarm.service.SetAlarmService;
import project.software.domain.alarm.service.UpdateAlarmService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final SetAlarmService setAlarmService;
    private final GetAllAlarmService getAllAlarmService;
    private final DeleteAlarmService deleteAlarmService;
    private final UpdateAlarmService updateAlarmService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void setAlarm(@RequestBody SetAlarmRequest request) {
        setAlarmService.execute(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AlarmListResponse getMyAlarms() {
        return getAllAlarmService.execute();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlarm(Long alarmId) {
        deleteAlarmService.execute(alarmId);
    }

    @PatchMapping("/{alarm-id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAlarm(@PathVariable("alarm-id") Long alarmId, @RequestBody @Valid SetAlarmRequest request) {
        updateAlarmService.execute(alarmId, request);
    }
}
