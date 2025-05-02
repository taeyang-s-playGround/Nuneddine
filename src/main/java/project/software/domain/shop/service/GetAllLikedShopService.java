package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.shop.controller.dto.response.ShopListResponse;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllLikedShopService {

    private final ShopRepository shopRepository;
    private final UserFacade userFacade;

    public ShopListResponse execute() {
        User user = userFacade.GetCurrentUser();
        List<Shop> shops = shopRepository.findShopsByUserId(user.getId());

        return new ShopListResponse(shops);
    }
}

