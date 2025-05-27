package project.software.domain.guide.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.guide.domain.Guide;
import project.software.domain.user.domain.User;

@Getter
@AllArgsConstructor
public class GuideDetailResponse {

    private String title;
    private String content;
    private String imageUrl;

    public GuideDetailResponse(Guide guide) {
        title = guide.getTitle();
        content = guide.getContent();
        imageUrl =  guide.getImageUrl();
    }
}
