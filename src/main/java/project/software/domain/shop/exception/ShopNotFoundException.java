package project.software.domain.shop.exception;

import project.software.global.security.config.error.exception.CustomException;
import project.software.global.security.config.error.exception.ErrorCode;

public class ShopNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new ShopNotFoundException();

    private ShopNotFoundException() {
        super(ErrorCode.SHOP_NOT_FOUND);
    }
}

