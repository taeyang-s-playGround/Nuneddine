package project.software.domain.alarm.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.LensDateType;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UpdateAlarmRequest {

    private String name;
    private LensDateType dateType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
