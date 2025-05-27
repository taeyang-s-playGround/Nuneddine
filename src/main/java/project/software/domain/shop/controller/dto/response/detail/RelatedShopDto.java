package project.software.domain.shop.controller.dto.response.detail;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.Hibernate;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;

import java.util.List;

@Getter
@Builder
public class RelatedShopDto {

    private final Long shopId;
    private final String brandName;
    private final String glassesName;
    private final Long price;
    private final List<String> imageUrls;
    private final Boolean isLiked;

    // Lens 전용
    private final LensColor lensColor;
    private final LensDateType dateType;

    // Glasses 전용
    private final FrameShape frameShape;

    public static RelatedShopDto from(Shop shop, boolean isLiked) {
        shop = (Shop) Hibernate.unproxy(shop);

        RelatedShopDtoBuilder builder = RelatedShopDto.builder()
            .shopId(shop.getId())
            .brandName(shop.getBrandName())
            .glassesName(shop.getGlassesName())
            .price(shop.getPrice())
            .imageUrls(shop.getImageUrls())
            .isLiked(isLiked);

        if (shop instanceof Lens lens) {
            builder.lensColor(lens.getLensColor())
                .dateType(lens.getDateType());
        } else if (shop instanceof Glasses glasses) {
            builder.frameShape(glasses.getFrameShape());
        }

        return builder.build();
    }
}
