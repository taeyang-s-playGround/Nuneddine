package project.software.domain.alarm.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UpdateAlarmRequest {

    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
