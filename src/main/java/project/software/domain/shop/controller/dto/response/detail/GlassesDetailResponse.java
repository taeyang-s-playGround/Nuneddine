package project.software.domain.shop.controller.dto.response.detail;

import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.user.domain.User;

import java.util.List;

@Getter
public class GlassesDetailResponse extends ShopDetailResponse {

    private final FrameShape frameShape;

    public GlassesDetailResponse(
        Glasses glasses,
        Boolean isLiked,
        List<Shop> relatedShops,
        User user,
        HeartRepository heartRepository
    ) {
        super(glasses, isLiked, relatedShops, user, heartRepository);
        this.frameShape = glasses.getFrameShape();
    }
}
