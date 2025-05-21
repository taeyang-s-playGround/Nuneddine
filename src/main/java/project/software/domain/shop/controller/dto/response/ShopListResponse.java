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

import java.util.List;

@Getter
@AllArgsConstructor
public class ShopListResponse {

    private final Long shopsCount;
    private final List<ShopResponse> shopList;

    public static ShopListResponse from(List<Shop> shops, Long userId, HeartRepository heartRepository) {
        List<ShopResponse> responses = shops.stream()
            .map(shop -> {
                LensDateType dateType = null;
                LensColor lensColor = null;
                FrameShape frameShape = null;
                FrameMaterial frameMaterial = null;
                ShopType shopType;

                if (shop instanceof Lens lens) {
                    dateType = lens.getDateType();
                    lensColor = lens.getLensColor();
                    shopType = ShopType.LENS;
                } else if (shop instanceof Glasses glasses) {
                    frameShape = glasses.getFrameShape();
                    frameMaterial = glasses.getFrameMaterial();
                    shopType = ShopType.GLASSES;
                } else {
                    throw new IllegalStateException("Unknown shop type: " + shop.getClass().getSimpleName());
                }

                return ShopResponse.builder()
                    .shopId(shop.getId())
                    .brandName(shop.getBrandName())
                    .glassesName(shop.getGlassesName())
                    .descriptionImage(shop.getDescriptionImage())
                    .price(shop.getPrice())
                    .dateType(dateType)
                    .imageUrls(shop.getImageUrls())
                    .isLiked(heartRepository.existsByUserIdAndShopId(userId, shop.getId()))
                    .shopType(shopType)
                    .build();
            })
            .toList();

        return new ShopListResponse((long) responses.size(), responses);
    }

    @Getter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ShopResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final String descriptionImage;
        private final Long price;

        private final LensDateType dateType;

        private final List<String> imageUrls;
        private final Boolean isLiked;
        private final ShopType shopType;
    }
}
