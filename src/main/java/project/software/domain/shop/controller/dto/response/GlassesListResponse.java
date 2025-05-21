package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;

import java.util.List;

@Getter
@AllArgsConstructor
public class GlassesListResponse {

    private final Long shopsCount;
    private final List<GlassesResponse> shopList;

    public static GlassesListResponse from(List<Glasses> glassesList, Long userId, HeartRepository heartRepository) {
        List<GlassesResponse> responses = glassesList.stream()
            .map(glasses -> GlassesResponse.builder()
                .shopId(glasses.getId())
                .brandName(glasses.getBrandName())
                .glassesName(glasses.getGlassesName())
                .description(glasses.getDescriptionImage())
                .price(glasses.getPrice())
                .frameShape(glasses.getFrameShape())
                .frameMaterial(glasses.getFrameMaterial())
                .imageUrls(glasses.getImageUrls())
                .isLiked(heartRepository.existsByUserIdAndShopId(userId, glasses.getId()))
                .build())
            .toList();

        return new GlassesListResponse((long) responses.size(), responses);
    }

    @Getter
    @Builder
    public static class GlassesResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final String description;
        private final Long price;
        private final FrameShape frameShape;
        private final FrameMaterial frameMaterial;
        private final List<String> imageUrls;
        private final Boolean isLiked;
    }
}
