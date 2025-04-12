package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.controller.dto.response.AllCartResponse;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GetAllCartService {

    private final CartRepository cartRepository;
    private final UserFacade userFacade;

    public AllCartResponse execute() {

        User user = userFacade.GetCurrentUser();
        List<Cart> carts = cartRepository.findAllByUserId(user.getId());

        Long totalPrice = carts.stream()
            .mapToLong(cart -> cart.getShop().getPrice() * cart.getCount())
            .sum();

        return AllCartResponse.from(carts, totalPrice);
    }
}
