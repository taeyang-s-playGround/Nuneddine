package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.type.ShopTag;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class LensListResponse {

    private final List<LensResponse> trendingList;
    private final List<LensResponse> hipsterList;
    private final List<LensResponse> hotNowList;
    private final List<LensResponse> classicList;

    public static LensListResponse from(List<Lens> lenses, Long userId, HeartRepository heartRepository) {
        Map<ShopTag, List<LensResponse>> tagMap = lenses.stream()
            .collect(Collectors.groupingBy(
                Lens::getShopTag,
                Collectors.mapping(lens -> LensResponse.builder()
                        .shopId(lens.getId())
                        .brandName(lens.getBrandName())
                        .glassesName(lens.getGlassesName())
                        .price(lens.getPrice())
                        .dateType(lens.getDateType())
                        .imageUrls(lens.getImageUrls())
                        .isLiked(heartRepository.existsByUserIdAndShopId(userId, lens.getId()))
                        .build(),
                    Collectors.toList()
                )
            ));

        return new LensListResponse(
            tagMap.getOrDefault(ShopTag.TRENDING, List.of()),
            tagMap.getOrDefault(ShopTag.HIPSTER, List.of()),
            tagMap.getOrDefault(ShopTag.HOT_NOW, List.of()),
            tagMap.getOrDefault(ShopTag.CLASSIC, List.of())
        );
    }

    @Getter
    @Builder
    public static class LensResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final Long price;
        private final LensDateType dateType;
        private final List<String> imageUrls;
        private final Boolean isLiked;
    }
}
