package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.heart.domain.repository.HeartRepository;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllShopService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;
    private final HeartRepository heartRepository;

    public ShopListResponse execute() {
        List<Shop> shops = shopRepository.findAll();

        User user = userFacade.GetCurrentUser();

        return ShopListResponse.from(shops, user.getId(), heartRepository);
    }
}
