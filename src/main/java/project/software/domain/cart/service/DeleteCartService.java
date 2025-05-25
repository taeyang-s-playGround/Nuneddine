package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.controller.dto.request.DeleteCartsRequest;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.cart.exception.CartNotFoundException;
import project.software.domain.user.domain.User;
import project.software.domain.user.exception.UserMisMatchException;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteCartService {

    private final CartRepository cartRepository;
    private final UserFacade userFacade;

    public void execute(DeleteCartsRequest request) {
        User user = userFacade.getCurrentUser();

        for (Long cartId : request.getCartIds()) {
            Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> CartNotFoundException.EXCEPTION);

            if (!cart.getUser().getId().equals(user.getId())) {
                throw UserMisMatchException.EXCEPTION;
            }

            cartRepository.delete(cart);
        }
    }
}
