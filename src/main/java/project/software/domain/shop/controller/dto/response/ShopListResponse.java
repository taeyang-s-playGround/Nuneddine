package project.software.domain.shop.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.shop.domain.type.GlassesType;
import project.software.domain.shop.domain.type.Type;

import java.util.List;

@Getter
@AllArgsConstructor
public class ShopListResponse {

    private final List<ShopResponse> shopList;
    private final Long shopsCount;

    public static ShopListResponse from(List<Shop> shops, Long userId, HeartRepository heartRepository) {
        List<ShopResponse> shopResponses = shops.stream()
            .map(shop -> ShopResponse.builder()
                .shopId(shop.getId())
                .brandName(shop.getBrandName())
                .glassesName(shop.getGlassesName())
                .description(shop.getDescription())
                .price(shop.getPrice())
                .type(shop.getType())
                .glassesType(shop.getGlassesType())
                .imageUrl(shop.getImageUrl())
                .isLiked(heartRepository.existsByUserIdAndShopId(userId, shop.getId()))
                .build())
            .toList();

        return new ShopListResponse(shopResponses, (long) shopResponses.size());
    }

    @Getter
    @Builder
    public static class ShopResponse {
        private final Long shopId;
        private final String brandName;
        private final String glassesName;
        private final String description;
        private final Long price;
        private final Type type;
        private final GlassesType glassesType;
        private final String imageUrl;
        private final Boolean isLiked;
    }
}