package project.software.domain.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.user.domain.User;

@Getter
@AllArgsConstructor
public class GetMyLensPowerResponse {
    private Long lensPower;

    public GetMyLensPowerResponse(User user) {
        lensPower = user.getLensPower();
    }
}
