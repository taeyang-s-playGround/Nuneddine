package project.software.domain.alarm.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class UpdateAlarmRequest {

    @NotNull
    private String name;

    @NotNull
    private LensDateType dateType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
