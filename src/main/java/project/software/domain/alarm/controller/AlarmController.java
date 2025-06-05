package project.software.domain.alarm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.alarm.controller.dto.request.SetAlarmRequest;
import project.software.domain.alarm.controller.dto.request.UpdateAlarmRequest;
import project.software.domain.alarm.controller.dto.response.AlarmListResponse;
import project.software.domain.alarm.domain.repository.AlarmRepository;
import project.software.domain.alarm.service.DeleteAlarmService;
import project.software.domain.alarm.service.GetAllAlarmService;
import project.software.domain.alarm.service.SetAlarmService;
import project.software.domain.alarm.service.ToggleRepurchaseService;
import project.software.domain.alarm.service.UpdateAlarmService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alarms")
public class AlarmController {

    private final SetAlarmService setAlarmService;
    private final GetAllAlarmService getAllAlarmService;
    private final DeleteAlarmService deleteAlarmService;
    private final UpdateAlarmService updateAlarmService;
    private final ToggleRepurchaseService toggleRepurchaseService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void setAlarm(@RequestBody @Valid SetAlarmRequest request) {
        setAlarmService.execute(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AlarmListResponse getMyAlarms() {
        return getAllAlarmService.execute();
    }

    @PatchMapping("/{alarm-id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateAlarm(@PathVariable("alarm-id") Long alarmId, @RequestBody @Valid UpdateAlarmRequest request) {
        updateAlarmService.execute(alarmId, request);
    }

    @DeleteMapping("/{alarm-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlarm(@PathVariable("alarm-id") Long alarmId) {
        deleteAlarmService.execute(alarmId);
    }

    @PatchMapping("/repurchase-toggle/{alarm-id}")
    @ResponseStatus(HttpStatus.OK)
    public void toggleRepurchase(@PathVariable("alarm-id") Long alarmId) {
        toggleRepurchaseService.execute(alarmId);
    }
}
