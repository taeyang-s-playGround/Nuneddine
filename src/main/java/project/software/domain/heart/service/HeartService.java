package project.software.domain.heart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.Heart;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartService {

    private final UserFacade userFacade;
    private final HeartRepository heartRepository;
    private final ShopRepository shopRepository;

    public void execute(Long shopId) {

        User user = userFacade.GetCurrentUser();

        if (heartRepository.existsByUserIdAndShopId(user.getId(), shopId)) {
            heartRepository.deleteByUserIdAndShopId(user.getId(), shopId);
        }
        else {
            Shop shop = shopRepository.findShopById(shopId);
            heartRepository.save(
                Heart.builder()
                    .user(user)
                    .shop(shop)
                    .build());
        }
    }    
}
