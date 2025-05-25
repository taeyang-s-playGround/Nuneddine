package project.software.domain.cart.exception;

import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class CartNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new CartNotFoundException();

    private CartNotFoundException() {
        super(ErrorCode.CART_NOT_FOUND);
    }
}
