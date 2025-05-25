package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.controller.dto.request.ChangeOptionRequest;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.shop.domain.Shop;
import project.software.domain.shop.domain.repository.ShopRepository;
import project.software.domain.shop.exception.ShopNotFoundException;
import project.software.domain.user.domain.User;

@Service
@RequiredArgsConstructor
@Transactional
public class AddCartService {

    private final UserFacade userFacade;
    private final CartRepository cartRepository;
    private final ShopRepository shopRepository;

    public void execute(Long shopId, ChangeOptionRequest request) {

        User user = userFacade.getCurrentUser();
        Shop shop = shopRepository.findById(shopId)
            .orElseThrow(() -> ShopNotFoundException.EXCEPTION);

        cartRepository.save(Cart.builder()
                .count(request.getCount())
                .user(user)
                .shop(shop)
                .lensPower(request.getLensPower())
            .build());
    }
}
