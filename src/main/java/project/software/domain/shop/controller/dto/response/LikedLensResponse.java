package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;

@Getter
@AllArgsConstructor
public class LikedLensResponse {

    private final Long shopsCount;
    private final List<LensResponse> shopList;

    public static LikedLensResponse from(List<Lens> lenses) {
        return new LikedLensResponse((long) lenses.size(),
            lenses.stream()
                .map(lens -> LensResponse.builder()
                    .shopId(lens.getId())
                    .brandName(lens.getBrandName())
                    .imageUrls(lens.getImageUrls())
                    .glassesName(lens.getGlassesName())
                    .dateType(lens.getDateType())
                    .price(lens.getPrice())
                    .build()
                ).toList()
        );
    }

    @Getter
    @Builder
    public static class LensResponse {
        private final Long shopId;
        private final String brandName;
        private final List<String> imageUrls;
        private final String glassesName;
        private final LensDateType dateType;
        private final Long price;
    }
}
