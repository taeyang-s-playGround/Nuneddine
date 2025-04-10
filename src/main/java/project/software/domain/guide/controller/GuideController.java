package project.software.domain.guide.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.guide.controller.dto.response.AllGuidesResponse;
import project.software.domain.guide.service.GetAllGuidesService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guides")
public class GuideController {

    private final GetAllGuidesService getAllGuidesService;

    @GetMapping
    public AllGuidesResponse getAllGuides() {
        return getAllGuidesService.execute();
    }
}
