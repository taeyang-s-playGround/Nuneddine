package project.software.domain.shop.controller.dto.response.detail;

import lombok.Getter;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.user.domain.User;

import java.util.List;

@Getter
public class LensDetailResponse extends ShopDetailResponse {

    private final LensColor lensColor;
    private final LensDateType dateType;

    public LensDetailResponse(
        Lens lens,
        Boolean isLiked,
        List<Shop> relatedShops,
        User user,
        HeartRepository heartRepository
    ) {
        super(lens, isLiked, relatedShops, user, heartRepository);
        this.lensColor = lens.getLensColor();
        this.dateType = lens.getDateType();
    }
}
