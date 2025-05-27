package project.software.domain.guide.controller.dto.response;

import project.software.domain.guide.domain.Guide;

import java.util.List;

public record AllGuidesResponse(List<Guide> guideList) {
    public record ClassResponse(Long guideId, String title, String imageUrl) {}
}
