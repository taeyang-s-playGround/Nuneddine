package project.software.domain.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.user.domain.User;

@Getter
@AllArgsConstructor
public class GetMyLensPowerResponse {
    private Float leftLensPower;
    private Float rightLensPower;

    public GetMyLensPowerResponse(User user) {
        leftLensPower = user.getLeftLensPower();
        rightLensPower = user.getRightLensPower();

    }
}
