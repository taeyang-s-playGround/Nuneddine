package project.software.domain.shop.controller.dto.response.detail;

import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.ShopTag;
import project.software.domain.shop.domain.type.ShopType;
import project.software.domain.user.domain.User;

import java.util.List;
import java.util.stream.Collectors;
@Getter
public class ShopDetailResponse {

    private final Long shopId;
    private final String brandName;
    private final String glassesName;
    private final String descriptionImage;
    private final Long price;
    private final List<String> imageUrls;
    private final ShopType shopType;
    private final ShopTag shopTag;
    private final String groupId;
    private final Boolean isLiked;
    private final List<RelatedShopDto> relatedShops;

    public ShopDetailResponse(
        Shop shop,
        Boolean isLiked,
        List<Shop> relatedShops,
        User user,
        HeartRepository heartRepository
    ) {
        this.shopId = shop.getId();
        this.brandName = shop.getBrandName();
        this.glassesName = shop.getGlassesName();
        this.descriptionImage = shop.getDescriptionImage();
        this.price = shop.getPrice();
        this.imageUrls = shop.getImageUrls();
        this.shopType = shop.getShopType();
        this.shopTag = shop.getShopTag();
        this.groupId = shop.getGroupId();
        this.isLiked = isLiked;
        this.relatedShops = relatedShops.stream()
            .map(s -> RelatedShopDto.from(s, heartRepository.existsByUserIdAndShopId(user.getId(), s.getId())))
            .collect(Collectors.toList());
    }
}
