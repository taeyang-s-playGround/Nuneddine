package project.software.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.user.controller.dto.request.UpdateAddressRequest;
import project.software.domain.user.controller.dto.response.GetMyPageResponse;
import project.software.domain.user.domain.repository.UserRepository;
import project.software.domain.user.service.GetMyPageService;
import project.software.domain.user.service.UpdateMyAddressService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final GetMyPageService getMyPageService;
    private final UpdateMyAddressService updateMyAddressService;

    @GetMapping("/my-page")
    @ResponseStatus(HttpStatus.OK)
    public GetMyPageResponse getMyPage() {
        return getMyPageService.execute();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateAddress(@RequestBody @Valid UpdateAddressRequest request) {
        updateMyAddressService.execute(request);
    }
}
