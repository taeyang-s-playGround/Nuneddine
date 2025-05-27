package project.software.domain.alarm.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class SetAlarmRequest {

    @NotBlank
    private String name;

    @NotBlank
    private LensDateType dateType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
