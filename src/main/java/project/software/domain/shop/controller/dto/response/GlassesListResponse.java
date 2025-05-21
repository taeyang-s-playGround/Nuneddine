package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.type.ShopTag;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class GlassesListResponse {

    private final Long shopsCount;
    private final List<GlassesResponse> trendingList;
    private final List<GlassesResponse> hipsterList;
    private final List<GlassesResponse> hotNowList;
    private final List<GlassesResponse> classicList;

    public static GlassesListResponse from(List<Glasses> glassesList, Long userId, HeartRepository heartRepository) {
        Map<ShopTag, List<GlassesResponse>> tagMap = glassesList.stream()
            .collect(Collectors.groupingBy(
                Glasses::getShopTag,
                Collectors.mapping(glasses -> GlassesResponse.builder()
                        .shopId(glasses.getId())
                        .brandName(glasses.getBrandName())
                        .glassesName(glasses.getGlassesName())
                        .description(glasses.getDescriptionImage())
                        .price(glasses.getPrice())
                        .frameShape(glasses.getFrameShape())
                        .frameMaterial(glasses.getFrameMaterial())
                        .imageUrls(glasses.getImageUrls())
                        .isLiked(heartRepository.existsByUserIdAndShopId(userId, glasses.getId()))
                        .build(),
                    Collectors.toList()
                )
            ));

        return new GlassesListResponse(
            (long) glassesList.size(),
            tagMap.getOrDefault(ShopTag.TRENDING, List.of()),
            tagMap.getOrDefault(ShopTag.HIPSTER, List.of()),
            tagMap.getOrDefault(ShopTag.HOT_NOW, List.of()),
            tagMap.getOrDefault(ShopTag.CLASSIC, List.of())
        );
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
