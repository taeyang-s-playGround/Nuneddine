package project.software.domain.guide.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllGuidesResponse {

    private List<GuideResponse> guideList;
    private List<TipResponse> tipList;

    @Getter
    @AllArgsConstructor
    public static class GuideResponse {
        private Long guideId;
        private String title;
        private String imageUrl;
    }

    @Getter
    @AllArgsConstructor
    public static class TipResponse {
        private String question;
        private String answer;
    }
}
