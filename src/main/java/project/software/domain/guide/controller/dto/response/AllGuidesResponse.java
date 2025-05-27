package project.software.domain.guide.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.guide.domain.Guide;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllGuidesResponse {

    private List<GuideResponse> guideList;
    private List<String> tipList;

    @Getter
    @AllArgsConstructor
    public static class GuideResponse {
        private Long guideId;
        private String title;
        private String imageUrl;
    }
}