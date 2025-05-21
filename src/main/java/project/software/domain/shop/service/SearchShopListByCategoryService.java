package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchShopListByCategoryService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;
    private final HeartRepository heartRepository;

    public ShopListResponse execute(String keyword, LensColor lensColor, LensDateType lensDateType,
                                    FrameShape frameShape, FrameMaterial frameMaterial) {

        User user = userFacade.GetCurrentUser();

        List<Shop> shops = shopRepository.findAll();

        List<Shop> filtered = shops.stream()
            .filter(shop -> {
                boolean matchesKeyword = keyword == null ||
                    (shop.getBrandName() != null && shop.getBrandName().contains(keyword)) ||
                    (shop.getGlassesName() != null && shop.getGlassesName().contains(keyword)) ||
                    (shop.getDescriptionImage() != null && shop.getDescriptionImage().contains(keyword));

                boolean matchesLens = shop instanceof Lens lens && (
                    (lensColor != null && lens.getLensColor() == lensColor) ||
                        (lensDateType != null && lens.getDateType() == lensDateType)
                );

                boolean matchesGlasses = shop instanceof Glasses glasses && (
                    (frameShape != null && glasses.getFrameShape() == frameShape) ||
                        (frameMaterial != null && glasses.getFrameMaterial() == frameMaterial)
                );

                boolean matchesOptional = lensColor == null && lensDateType == null && frameShape == null && frameMaterial == null;

                return matchesKeyword && (matchesLens || matchesGlasses || matchesOptional);
            })
            .toList();

        return ShopListResponse.from(filtered, user.getId(), heartRepository);
    }
}
