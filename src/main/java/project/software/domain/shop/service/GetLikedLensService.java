package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.shop.controller.dto.response.LikedLensResponse;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetLikedLensService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;

    public LikedLensResponse execute() {
        User user = userFacade.getCurrentUser();

        List<Shop> likedShops = shopRepository.findShopsByUserId(user.getId());
        List<Lens> likedLenses = likedShops.stream()
            .filter(shop -> shop instanceof Lens)
            .map(shop -> (Lens) shop)
            .toList();

        return LikedLensResponse.from(likedLenses);
    }
}
