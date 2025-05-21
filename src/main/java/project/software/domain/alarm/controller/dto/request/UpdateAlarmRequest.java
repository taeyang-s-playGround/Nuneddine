package project.software.domain.alarm.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UpdateAlarmRequest {

    @NotBlank
    private String name;

    @NotBlank
    private LensDateType dateType;

    @NotBlank
    private LocalDateTime startTime;

    @NotBlank
    private LocalDateTime endTime;
}
