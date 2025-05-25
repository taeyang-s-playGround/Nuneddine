package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.shop.controller.dto.response.LikedGlassesResponse;
import project.software.domain.shop.controller.dto.response.LikedLensResponse;
import project.software.domain.shop.domain.Glasses;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetLikedGlassesService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;

    public LikedGlassesResponse execute() {
        User user = userFacade.getCurrentUser();

        List<Shop> likedShops = shopRepository.findShopsByUserId(user.getId());
        List<Glasses> likedGlasses = likedShops.stream()
            .filter(shop -> shop instanceof Glasses)
            .map(shop -> (Glasses) shop)
            .toList();

        return LikedGlassesResponse.from(likedGlasses);
    }
}
