package project.software.domain.shop.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.ShopType;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class ShopListResponse {

    private final List<String> filter;
    private final Long shopsCount;
    private final List<ShopResponse> shopList;

    public static ShopListResponse from(List<Shop> shops, Long userId, HeartRepository heartRepository,
                                        List<LensColor> lensColors, List<LensDateType> lensDateTypes,
                                        List<FrameShape> frameShapes, List<FrameMaterial> frameMaterials) {

        List<ShopResponse> responses = shops.stream()
            .map(shop -> {
                LensDateType dateType = null;
                ShopType shopType;

                if (shop instanceof Lens lens) {
                    dateType = lens.getDateType();
                    shopType = ShopType.LENS;
                } else if (shop instanceof Glasses) {
                    shopType = ShopType.GLASSES;
                } else {
                    throw new IllegalStateException("Unknown shop type: " + shop.getClass().getSimpleName());
                }

                return ShopResponse.builder()
                    .shopId(shop.getId())
                    .brandName(shop.getBrandName())
                    .glassesName(shop.getGlassesName())
                    .price(shop.getPrice())
                    .dateType(dateType)
                    .imageUrls(shop.getImageUrls())
                    .isLiked(heartRepository.existsByUserIdAndShopId(userId, shop.getId()))
                    .shopType(shopType)
                    .build();
            })
            .toList();

        List<String> filter = new ArrayList<>();

        if (lensColors != null) {
            filter.addAll(
                lensColors.stream()
                    .filter(Objects::nonNull)
                    .map(Enum::name)
                    .toList()
            );
        }
        if (lensDateTypes != null) {
            filter.addAll(
                lensDateTypes.stream()
                    .filter(Objects::nonNull)
                    .map(Enum::name)
                    .toList()
            );
        }
        if (frameShapes != null) {
            filter.addAll(
                frameShapes.stream()
                    .filter(Objects::nonNull)
                    .map(Enum::name)
                    .toList()
            );
        }
        if (frameMaterials != null) {
            filter.addAll(
                frameMaterials.stream()
                    .filter(Objects::nonNull)
                    .map(Enum::name)
                    .toList()
            );
        }
        return new ShopListResponse(filter, (long) responses.size(), responses);
    }

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ShopResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final Long price;
        private final LensDateType dateType;
        private final List<String> imageUrls;
        private final Boolean isLiked;
        private final ShopType shopType;
    }
}
