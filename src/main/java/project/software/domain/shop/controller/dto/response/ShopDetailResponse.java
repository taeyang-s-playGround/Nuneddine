package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.ShopType;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;

@Getter
@AllArgsConstructor
public class ShopDetailResponse {

    private final Long shopId;
    private final String brandName;
    private final String glassesName;
    private final String descriptionImage;
    private final Long price;

    private final LensDateType dateType;
    private final LensColor lensColor;
    private final FrameShape frameShape;

    private final List<String> imageUrls;
    private final Boolean isLiked;
    private final ShopType shopType;

    private final List<RecommendedShop> recommendedList;

    public static ShopDetailResponse from(Shop shop, Long userId, HeartRepository heartRepository, List<Shop> allShops) {
        LensDateType dateType = null;
        LensColor lensColor = null;
        FrameShape frameShape = null;
        ShopType shopType;

        if (shop instanceof Lens lens) {
            dateType = lens.getDateType();
            lensColor = lens.getLensColor();
            shopType = ShopType.LENS;
        } else if (shop instanceof Glasses glasses) {
            frameShape = glasses.getFrameShape();
            shopType = ShopType.GLASSES;
        } else {
            throw new IllegalStateException("Unknown shop type: " + shop.getClass().getSimpleName());
        }

        List<RecommendedShop> recommended = allShops.stream()
            .filter(s -> !s.getId().equals(shop.getId()) && s.getGroupId().equals(shop.getGroupId()))
            .map(s -> new RecommendedShop(s.getId(), s.getImageUrls().isEmpty() ? null : s.getImageUrls().get(0)))
            .toList();

        return new ShopDetailResponse(
            shop.getId(),
            shop.getBrandName(),
            shop.getGlassesName(),
            shop.getDescriptionImage(),
            shop.getPrice(),
            dateType,
            lensColor,
            frameShape,
            shop.getImageUrls(),
            heartRepository.existsByUserIdAndShopId(userId, shop.getId()),
            shopType,
            recommended
        );
    }

    @Getter
    @AllArgsConstructor
    public static class RecommendedShop {
        private final Long shopId;
        private final String thumbnailImage;
    }
}