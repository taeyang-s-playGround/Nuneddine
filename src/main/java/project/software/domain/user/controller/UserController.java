package project.software.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.user.controller.dto.request.UpdateAccountIdRequest;
import project.software.domain.user.controller.dto.request.UpdateLensPowerRequest;
import project.software.domain.user.controller.dto.response.GetMyLensPowerResponse;
import project.software.domain.user.controller.dto.response.GetMyPageResponse;
import project.software.domain.user.service.GetMyLensPowerService;
import project.software.domain.user.service.GetMyPageService;
import project.software.domain.user.service.UpdateAccountIdService;
import project.software.domain.user.service.UpdateMyLensPowerService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final GetMyPageService getMyPageService;
    private final UpdateMyLensPowerService updateMyLensPowerService;
    private final GetMyLensPowerService getMyLensPowerService;
    private final UpdateAccountIdService updateAccountIdService;

    @GetMapping("/my-page")
    @ResponseStatus(HttpStatus.OK)
    public GetMyPageResponse getMyPage() {
        return getMyPageService.execute();
    }

    @PatchMapping("/lens")
    @ResponseStatus(HttpStatus.OK)
    public void updateLensPower(@RequestBody @Valid UpdateLensPowerRequest request) {
        updateMyLensPowerService.execute(request);
    }

    @PatchMapping("/info")
    @ResponseStatus(HttpStatus.OK)
    public void updateUserInfo(@RequestBody @Valid UpdateAccountIdRequest request) {
        updateAccountIdService.execute(request);
    }

    @GetMapping("/lens")
    @ResponseStatus(HttpStatus.OK)
    public GetMyLensPowerResponse getMyLensPower() {
        return getMyLensPowerService.execute();
    }
}
