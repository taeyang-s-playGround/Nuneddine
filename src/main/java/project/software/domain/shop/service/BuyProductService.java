package project.software.domain.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.purchase_history.domain.PurchaseHistory;
import project.software.domain.purchase_history.domain.repository.PurchaseHistoryRepository;
import project.software.domain.user.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyProductService {

    private final UserFacade userFacade;
    private final CartRepository cartRepository;
    private final PurchaseHistoryRepository purchaseHistoryRepository;

    public void execute() {
        User user = userFacade.GetCurrentUser();

        //cart에 있는 것들을 전부 delete하고
        //purchaseHistory에 그대로 만들어줌

        List<Cart> carts = cartRepository.findAllByUserId(user.getId());
        carts.forEach(cart -> {
            cartRepository.deleteById(cart.getId());

            purchaseHistoryRepository.save(PurchaseHistory.builder()
                .count(cart.getCount())
                .shop(cart.getShop())
                .user(user)
                .build()
            );
        });
    }
}
