package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.controller.dto.response.detail.ShopDetailResponse;
import project.software.domain.shop.controller.dto.response.detail.GlassesDetailResponse;
import project.software.domain.shop.controller.dto.response.detail.LensDetailResponse;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.shop.exception.ShopNotFoundException;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetShopDetailService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;
    private final HeartRepository heartRepository;
    public ShopDetailResponse execute(Long shopId) {
        Shop shop = shopRepository.findById(shopId)
            .orElseThrow(() -> ShopNotFoundException.EXCEPTION);

        User user = userFacade.getCurrentUser();
        boolean isLiked = heartRepository.existsByUserIdAndShopId(user.getId(), shop.getId());

        Shop realShop = (Shop) Hibernate.unproxy(shop);
        List<Shop> relatedShops = shopRepository.findByGroupIdAndIdNot(realShop.getGroupId(), realShop.getId());

        if (realShop instanceof Glasses glasses) {
            return new GlassesDetailResponse(glasses, isLiked, relatedShops, user, heartRepository);
        } else if (realShop instanceof Lens lens) {
            return new LensDetailResponse(lens, isLiked, relatedShops, user, heartRepository);
        } else {
            throw new IllegalStateException("지원하지 않는 Shop 타입입니다.");
        }
    }
}
