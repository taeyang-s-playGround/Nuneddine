package project.software.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateLensPowerRequest {

    private Float leftLensPower;

    private Float rightLensPower;

}
