package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.controller.dto.response.LensCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.shop.domain.Lens;
import project.software.domain.shop.domain.type.ShopType;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetLensCartService {

    private final CartRepository cartRepository;
    private final UserFacade userFacade;

    public LensCartResponse execute() {
        User user = userFacade.getCurrentUser();

        List<Cart> carts = cartRepository.findAllByUserId(user.getId())
            .stream()
            .filter(cart -> cart.getShop().getShopType() == ShopType.LENS) // 여기 변경
            .toList();

        Long totalPrice = carts.stream()
            .mapToLong(cart -> cart.getShop().getPrice() * cart.getCount())
            .sum();

        return LensCartResponse.from(carts, totalPrice);
    }
}
