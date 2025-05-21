package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;

@Getter
@AllArgsConstructor
public class LensListResponse {

    private final Long shopsCount;
    private final List<LensResponse> shopList;

    public static LensListResponse from(List<Lens> lenses, Long userId, HeartRepository heartRepository) {
        List<LensResponse> responses = lenses.stream()
            .map(lens -> LensResponse.builder()
                .shopId(lens.getId())
                .brandName(lens.getBrandName())
                .glassesName(lens.getGlassesName())
                .description(lens.getDescriptionImage())
                .price(lens.getPrice())
                .dateType(lens.getDateType())
                .lensColor(lens.getLensColor())
                .imageUrls(lens.getImageUrls())
                .isLiked(heartRepository.existsByUserIdAndShopId(userId, lens.getId()))
                .build())
            .toList();

        return new LensListResponse((long) responses.size(), responses);
    }

    @Getter
    @Builder
    public static class LensResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final String description;
        private final Long price;
        private final LensDateType dateType;
        private final LensColor lensColor;
        private final List<String> imageUrls;
        private final Boolean isLiked;
    }
}