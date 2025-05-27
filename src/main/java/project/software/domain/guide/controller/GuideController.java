package project.software.domain.guide.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.software.domain.guide.controller.dto.response.AllGuidesResponse;
import project.software.domain.guide.controller.dto.response.GuideDetailResponse;
import project.software.domain.guide.service.GetAllGuidesService;
import project.software.domain.guide.service.GuideDetailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guides")
public class GuideController {

    private final GetAllGuidesService getAllGuidesService;
    private final GuideDetailService guideDetailService;

    @GetMapping
    public AllGuidesResponse getAllGuides() {
        return getAllGuidesService.execute();
    }

    @GetMapping("/{guide-id}")
    public GuideDetailResponse getGuideDetail(@PathVariable("guide-id") Long guideId) {
        return guideDetailService.execute(guideId);
    }
}
