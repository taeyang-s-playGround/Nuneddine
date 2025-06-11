package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Keyword;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.KeywordRepository;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.shop.domain.type.glasses.FrameMaterial;
import project.software.domain.shop.domain.type.glasses.FrameShape;
import project.software.domain.shop.domain.type.lens.LensColor;
import project.software.domain.shop.domain.type.lens.LensDateType;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SearchShopListByCategoryService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;
    private final HeartRepository heartRepository;
    private final KeywordRepository keywordRepository;

    public ShopListResponse execute(String keyword,
                                    List<LensColor> lensColors,
                                    List<LensDateType> lensDateTypes,
                                    List<FrameShape> frameShapes,
                                    List<FrameMaterial> frameMaterials) {

        User user = userFacade.getCurrentUser();

        keywordRepository.save(Keyword.builder()
            .keyword(keyword)
            .user(user)
            .build());

        List<Shop> shops = shopRepository.findAll();

        List<Shop> filtered = shops.stream()
            .filter(shop -> {
                boolean matchesKeyword = keyword == null ||
                    (shop.getBrandName() != null && shop.getBrandName().contains(keyword)) ||
                    (shop.getGlassesName() != null && shop.getGlassesName().contains(keyword)) ||
                    (shop.getDescriptionImage() != null && shop.getDescriptionImage().contains(keyword));

                boolean matchesLens = shop instanceof Lens lens && (
                    (lensColors != null && !lensColors.isEmpty() && lensColors.contains(lens.getLensColor())) ||
                        (lensDateTypes != null && !lensDateTypes.isEmpty() && lensDateTypes.contains(lens.getDateType()))
                );

                boolean matchesGlasses = shop instanceof Glasses glasses && (
                    (frameShapes != null && !frameShapes.isEmpty() && frameShapes.contains(glasses.getFrameShape())) ||
                        (frameMaterials != null && !frameMaterials.isEmpty() && frameMaterials.contains(glasses.getFrameMaterial()))
                );

                boolean noFilterProvided = (lensColors == null || lensColors.isEmpty()) &&
                    (lensDateTypes == null || lensDateTypes.isEmpty()) &&
                    (frameShapes == null || frameShapes.isEmpty()) &&
                    (frameMaterials == null || frameMaterials.isEmpty());

                return matchesKeyword && (matchesLens || matchesGlasses || noFilterProvided);
            })
            .toList();

        return ShopListResponse.from(
            filtered,
            user.getId(),
            heartRepository,
            lensColors,
            lensDateTypes,
            frameShapes,
            frameMaterials
        );
    }
}
