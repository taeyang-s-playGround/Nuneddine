package project.software.domain.cart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.software.domain.auth.facade.UserFacade;
import project.software.domain.cart.controller.dto.request.ChangeOptionRequest;
import project.software.domain.cart.domain.Cart;
import project.software.domain.cart.domain.repository.CartRepository;
import project.software.domain.cart.exception.CartNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class ChangeOptionService {

    private final CartRepository cartRepository;
    private final UserFacade userFacade;

    public void execute(Long cartId, ChangeOptionRequest request) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(()-> CartNotFoundException.EXCEPTION);

        cart.updateCart(request.getCount(), request.getLensPower());
        cartRepository.save(cart);//더티체킹 있긴한데 그냥 해주기
    }
}
